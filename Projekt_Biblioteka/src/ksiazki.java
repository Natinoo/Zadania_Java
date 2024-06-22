import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ksiazki extends JFrame {
    private JPanel panel1;
    private JButton wyjscieButton;
    private JButton wsteczButton;
    private JTextField authorField;
    private JTextField nameField;
    private JTextField ammountField;
    private JButton dodajButton;
    private JLabel PanelU;
    private JTable table1;
    private int loggedInUserId;
    private int width = 700, height = 350;

    public ksiazki(int userId) {
        super("Panel Administratora");
        this.loggedInUserId = userId;
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

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

        this.setVisible(true);
    }

    private void addBook() {
        String author = authorField.getText().trim();
        String name = nameField.getText().trim().toLowerCase();
        String ammountText = ammountField.getText().trim();

        if (author.isEmpty() || name.isEmpty() || ammountText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Wszystkie pola muszą być wypełnione!", "Błąd", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int ilosc;
        try {
            ilosc = Integer.parseInt(ammountText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ilość musi być liczbą całkowitą!", "Błąd", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            // Sprawdzanie, czy książka o danym tytule już istnieje
            String checkQuery = "SELECT book_ID, book_ammount FROM ksiazki WHERE LOWER(TRIM(book_name)) = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
                checkStatement.setString(1, name);
                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int existingBookId = resultSet.getInt("book_ID");
                        int existingAmmount = resultSet.getInt("book_ammount");

                        int response = JOptionPane.showConfirmDialog(null, "Książka o takim tytule już istnieje! Czy chcesz dodać podaną ilość książek do istniejącej pozycji?", "Książka już istnieje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            // Dodanie ilości do istniejącej książki
                            String updateQuery = "UPDATE ksiazki SET book_ammount = ? WHERE book_ID = ?";
                            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                                updateStatement.setInt(1, existingAmmount + ilosc);
                                updateStatement.setInt(2, existingBookId);
                                updateStatement.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Ilość książek została zaktualizowana pomyślnie!", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                                clearForm();
                            }
                        }
                        return;
                    }
                }
            }

            // Dodawanie nowej książki do bazy danych
            String insertQuery = "INSERT INTO ksiazki (book_author, book_name, book_ammount) VALUES (?, ?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, author);
                insertStatement.setString(2, name);
                insertStatement.setInt(3, ilosc);
                insertStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Książka została dodana pomyślnie!", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Błąd dodawania książki do bazy danych: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        authorField.setText("");
        nameField.setText("");
        ammountField.setText("");
    }
}
