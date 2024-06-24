import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class RadioForm extends JFrame {
    private JButton wyjscieButton;
    private JButton wsteczButton;
    private JPanel panelRadio;
    private JTable table1;
    private DefaultTableModel tableModel;
    private JButton wypożyczButton;
    private int width = 800, height = 650;
    private int loggedInUserId; // ID zalogowanego użytkownika

    public RadioForm(int userId) {
        super("Biblioteka Rzeszowska");
        this.loggedInUserId = userId;
        this.setContentPane(this.panelRadio);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        String[] columnNames = {"Id książki", "Tytuł książki", "Autor", "Dostępne"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table1.setModel(tableModel);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        wsteczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainSystem main = new MainSystem(loggedInUserId);
                main.setVisible(true);
            }
        });

        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        wypożyczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wypożyczKsiążki();
            }
        });

        populateBookTable();
    }

    private void populateBookTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nazwa");
        model.addColumn("Autor");
        model.addColumn("Dostępne");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT book_ID, book_name, book_author, book_ammount FROM ksiazki WHERE book_ammount > 0";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("book_ID");
                        String nazwa = resultSet.getString("book_name");
                        String autor = resultSet.getString("book_author");
                        int ilosc = resultSet.getInt("book_ammount");
                        model.addRow(new Object[]{id, nazwa, autor, ilosc});
                    }
                }
            }

            table1.setModel(model);
            adjustColumnWidths();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Błąd pobierania danych z bazy danych: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void wypożyczKsiążki() {
        int[] selectedRows = table1.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(null, "Nie wybrano żadnej książki do wypożyczenia.", "Błąd", JOptionPane.WARNING_MESSAGE);
            return;
        }

        LocalDate dataWyp = LocalDate.now();
        LocalDate dataZwrotu = dataWyp.plusWeeks(4);

        try (Connection connection = DatabaseConnection.getConnection()) {
            String insertQuery = "INSERT INTO wyporzyczenia (user_id, book_id, data_wyp, data_zwrotu, naleznosc) VALUES (?, ?, ?, ?, ?)";
            String updateQuery = "UPDATE ksiazki SET book_ammount = book_ammount - 1 WHERE book_ID = ?";

            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                 PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                for (int row : selectedRows) {
                    int bookId = (int) table1.getValueAt(row, 0);

                    insertStatement.setInt(1, loggedInUserId);
                    insertStatement.setInt(2, bookId);
                    insertStatement.setDate(3, java.sql.Date.valueOf(dataWyp));
                    insertStatement.setDate(4, java.sql.Date.valueOf(dataZwrotu));
                    insertStatement.setDouble(5, 0.0);

                    insertStatement.addBatch();

                    updateStatement.setInt(1, bookId);
                    updateStatement.addBatch();
                }

                insertStatement.executeBatch();
                updateStatement.executeBatch();
                JOptionPane.showMessageDialog(null, "Książki zostały wypożyczone pomyślnie.", "Sukces", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Błąd wypożyczania książek: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }

        populateBookTable();
    }

    private void adjustColumnWidths() {
        for (int columnIndex = 0; columnIndex < table1.getColumnCount(); columnIndex++) {
            TableColumn column = table1.getColumnModel().getColumn(columnIndex);
            int maxWidth = 0;

            for (int rowIndex = 0; rowIndex < table1.getRowCount(); rowIndex++) {
                TableCellRenderer renderer = table1.getCellRenderer(rowIndex, columnIndex);
                Component comp = table1.prepareRenderer(renderer, rowIndex, columnIndex);
                maxWidth = Math.max(comp.getPreferredSize().width + table1.getIntercellSpacing().width, maxWidth);
            }

            column.setPreferredWidth(maxWidth);
        }
    }
}
