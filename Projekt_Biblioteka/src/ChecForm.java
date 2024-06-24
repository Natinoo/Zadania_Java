import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChecForm extends JFrame {
    private int width = 800, height = 650;
    private JPanel panel1;
    private JLabel PanelU;
    private JTable table1;
    private DefaultTableModel tableModel;
    private JButton wyjscieButton;
    private JButton oddajKsiążkeButton;
    private JButton wsteczButton;
    private int loggedInUserId; // ID zalogowanego użytkownika

    public ChecForm(int userId) {
        super("ChecForm");
        this.loggedInUserId = userId;
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);

        String[] columnNames = {"ID Wypożyczenia", "Id książki", "Tytuł książki", "Autor", "Termin zwrotu", "Należność"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table1.setModel(tableModel);

        // Ukryj kolumnę ID_wypozyczenia
        table1.getColumnModel().getColumn(0).setMinWidth(0);
        table1.getColumnModel().getColumn(0).setMaxWidth(0);
        table1.getColumnModel().getColumn(0).setWidth(0);
        table1.getColumnModel().getColumn(0).setPreferredWidth(0);

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

        oddajKsiążkeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oddajKsiazki();
            }
        });

        this.setVisible(true);

        updateFines();
        populateBorrowedBooksTable(loggedInUserId);
    }

    private void populateBorrowedBooksTable(int userId) {
        tableModel.setRowCount(0);

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT wyporzyczenia.ID_wyp AS id_wypozyczenia, ksiazki.book_ID AS id_ksiazki, " +
                    "ksiazki.book_name AS tytul_ksiazki, ksiazki.book_author AS autor, " +
                    "wyporzyczenia.data_zwrotu AS data_zwrotu, wyporzyczenia.naleznosc AS naleznosc " +
                    "FROM wyporzyczenia " +
                    "JOIN ksiazki ON wyporzyczenia.book_id = ksiazki.book_ID " +
                    "WHERE wyporzyczenia.user_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, userId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int borrowId = resultSet.getInt("id_wypozyczenia");
                        int bookId = resultSet.getInt("id_ksiazki");
                        String bookName = resultSet.getString("tytul_ksiazki");
                        String bookAuthor = resultSet.getString("autor");
                        String returnDate = resultSet.getString("data_zwrotu");
                        double fine = resultSet.getDouble("naleznosc");

                        Object[] row = {borrowId, bookId, bookName, bookAuthor, returnDate, fine};
                        tableModel.addRow(row);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Błąd pobierania danych z bazy danych: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void oddajKsiazki() {
        int[] selectedRows = table1.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(null, "Nie wybrano żadnej książki do oddania.", "Błąd", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String deleteQuery = "DELETE FROM wyporzyczenia WHERE ID_wyp = ?";
            String updateQuery = "UPDATE ksiazki SET book_ammount = book_ammount + 1 WHERE book_ID = ?";

            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                 PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                for (int row : selectedRows) {
                    int modelRow = table1.convertRowIndexToModel(row); // Pobierz właściwy indeks w modelu
                    int borrowId = (int) tableModel.getValueAt(modelRow, 0);
                    int bookId = (int) tableModel.getValueAt(modelRow, 1);

                    deleteStatement.setInt(1, borrowId);
                    deleteStatement.addBatch();

                    updateStatement.setInt(1, bookId);
                    updateStatement.addBatch();
                }

                deleteStatement.executeBatch();
                updateStatement.executeBatch();
                JOptionPane.showMessageDialog(null, "Książki zostały oddane pomyślnie.", "Sukces", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Błąd oddawania książek: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }

        populateBorrowedBooksTable(loggedInUserId);
    }

    private void updateFines() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String selectQuery = "SELECT ID_wyp, data_zwrotu FROM wyporzyczenia WHERE data_zwrotu < CURDATE()";
            String updateQuery = "UPDATE wyporzyczenia SET naleznosc = ? WHERE ID_wyp = ?";

            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                 PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int borrowId = resultSet.getInt("ID_wyp");
                        LocalDate returnDate = resultSet.getDate("data_zwrotu").toLocalDate();
                        long overdueDays = ChronoUnit.DAYS.between(returnDate, LocalDate.now());
                        double fine = overdueDays * 1.0; // 1 zł za każdy dzień zwłoki

                        updateStatement.setDouble(1, fine);
                        updateStatement.setInt(2, borrowId);
                        updateStatement.addBatch();
                    }
                }

                updateStatement.executeBatch();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Błąd aktualizacji należności: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
