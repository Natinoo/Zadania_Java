import javax.swing.*;
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
import java.util.ArrayList;
import java.util.List;

public class uzytkownik extends JFrame {
    private JPanel panel1;
    private JLabel PanelU;
    private JTable table1;
    private DefaultTableModel tableModel;
    private JButton wyjscieButton;
    private JButton wsteczButton;
    private JButton usuńButton;
    private int loggedInUserId;

    private int width = 800, height = 650;

    public uzytkownik(int userId) {
        super("Panel użytkownika");
        this.loggedInUserId = userId;
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);

        // Definiujemy kolumny tabeli
        String[] columnNames = {"ID", "Imię", "Nazwisko", "Mail", "Suma zaległości"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table1.setModel(tableModel);

        populateUsersTable();

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

        usuńButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow >= 0) {
                    int userId = (int) tableModel.getValueAt(selectedRow, 0);
                    int confirmed = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usunąć tego użytkownika?", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                    if (confirmed == JOptionPane.YES_OPTION) {
                        deleteUserAccount(userId);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wybierz użytkownika do usunięcia.", "Brak wyboru", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        this.setVisible(true);
    }

    private void populateUsersTable() {
        tableModel.setRowCount(0); // Wyczyść tabelę przed dodaniem nowych danych

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT ID, imie AS Imię, nazwisko AS Nazwisko, mail AS Mail, " +
                    "COALESCE(SUM(wyporzyczenia.naleznosc), 0) AS 'Suma zaległości' " +
                    "FROM user " +
                    "LEFT JOIN wyporzyczenia ON user.ID = wyporzyczenia.user_id " +
                    "GROUP BY user.ID";

            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                List<Object[]> rows = new ArrayList<>();
                while (resultSet.next()) {
                    int userId = resultSet.getInt("ID");
                    String firstName = resultSet.getString("Imię");
                    String lastName = resultSet.getString("Nazwisko");
                    String email = resultSet.getString("Mail");
                    double totalFines = resultSet.getDouble("Suma zaległości");

                    Object[] row = {userId, firstName, lastName, email, totalFines};
                    rows.add(row);
                }

                // Wypełnianie modelu tabeli danymi
                for (Object[] row : rows) {
                    tableModel.addRow(row);
                }

                // Ustawianie szerokości kolumn
                adjustColumnWidths();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Błąd pobierania danych z bazy danych: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adjustColumnWidths() {
        // Przechodzenie przez każdą kolumnę i ustawianie jej szerokości na szerokość najszerszego elementu
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            TableColumn column = table1.getColumnModel().getColumn(columnIndex);
            int maxWidth = 0;

            // Pobieranie maksymalnej szerokości dla danej kolumny
            for (int row = 0; row < table1.getRowCount(); row++) {
                TableCellRenderer renderer = table1.getCellRenderer(row, columnIndex);
                Component comp = table1.prepareRenderer(renderer, row, columnIndex);
                maxWidth = Math.max(comp.getPreferredSize().width + table1.getIntercellSpacing().width, maxWidth);
            }
            // Ustawianie preferowanej szerokości kolumny
            column.setPreferredWidth(maxWidth);
            // Jest to robione aby nie marnowac wolnego miejsca
        }
    }

    private void deleteUserAccount(int userId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM user WHERE ID = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, userId);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Konto użytkownika zostało usunięte.", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                    populateUsersTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Nie udało się usunąć konta użytkownika.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Błąd aktualizacji bazy danych: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
