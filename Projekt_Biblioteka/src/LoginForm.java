import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginForm extends JFrame {

    private JPanel panel1;
    private JTextField userName;
    private JPasswordField userPassword;
    private JLabel login;
    private JLabel haslo;
    private JButton wyjscieButton;
    private JButton zalogujButton;
    private JButton Rejestr;
    private int width = 600, height = 450;

    public LoginForm() {
        super("Logowanie do Systemu");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userNameInput = userName.getText();
                String userPasswordInput = new String(userPassword.getPassword());

                loginUser(userNameInput, userPasswordInput);
            }
        });

        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        Rejestr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RejestrForm rejestr = new RejestrForm();
                rejestr.setVisible(true);
            }
        });
    }

    private void loginUser(String username, String password) {
        // Sprawdzenie danych logowania i uzyskanie ID użytkownika
        int userId = getUserIdFromDatabase(username, password);

        if (userId != -1) { // Jeśli logowanie jest udane
            dispose(); // Zamknij okno logowania
            MainSystem main = new MainSystem(userId); // Przekazanie ID użytkownika do MainSystem
            main.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nieprawidłowe dane logowania", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int getUserIdFromDatabase(String username, String password) {
        int userId = -1;

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT ID FROM user WHERE mail = ? AND haslo = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        userId = resultSet.getInt("ID");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Błąd połączenia z bazą danych: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }

        return userId;
    }

}
