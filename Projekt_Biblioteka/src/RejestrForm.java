import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class RejestrForm extends JFrame {
    private JPanel panel1;
    private JLabel email;
    private JLabel haslo;
    private JTextField userMail;
    private JPasswordField userPassword;
    private JButton wsteczButton;
    private JButton zarejestrujSięButton;
    private JLabel imie;
    private JLabel nazwisko;
    private JLabel powtorzHaslo;
    private JTextField userName;
    private JTextField userSurrname;
    private JPasswordField userPasswordRepeat;

    private int width = 500, height = 400;

    public RejestrForm() {
        super("Kreator Konta");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        wsteczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm login = new LoginForm();
                login.setVisible(true);
            }
        });

        zarejestrujSięButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameInput = userName.getText();
                String surnameInput = userSurrname.getText();
                String emailInput = userMail.getText();
                String passwordInput = new String(userPassword.getPassword());
                String passwordRepeatInput = new String(userPasswordRepeat.getPassword());

                // Walidacja imienia
                if (nameInput.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Imię jest wymagane.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Walidacja e-mail
                if (!isValidEmail(emailInput)) {
                    JOptionPane.showMessageDialog(null, "Podano niepoprawny adres e-mail.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Walidacja hasła
                if (!isValidPassword(passwordInput)) {
                    JOptionPane.showMessageDialog(null, "Hasło musi mieć co najmniej 8 znaków, zawierać co najmniej jedną dużą literę i jeden znak specjalny.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    userPassword.setText("");
                    userPasswordRepeat.setText("");
                    return;
                }

                // Sprawdzenie czy hasła są zgodne
                if (passwordInput.equals(passwordRepeatInput)) {
                    if (registerUser(nameInput, surnameInput, emailInput, passwordInput)) {
                        JOptionPane.showMessageDialog(null, "Rejestracja zakończona sukcesem!", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        LoginForm login = new LoginForm();
                        login.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Rejestracja nie powiodła się. Spróbuj ponownie.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hasła nie są zgodne.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    userPassword.setText("");
                    userPasswordRepeat.setText("");
                }
            }
        });
    }

    private boolean isValidEmail(String email) {
        return email.contains("@");
    }

    private boolean isValidPassword(String password) {
        // Hasło musi mieć co najmniej 8 znaków, jedną dużą literę i jeden znak specjalny
        if (password.length() < 8) return false;
        if (!Pattern.compile("[A-Z]").matcher(password).find()) return false;
        if (!Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) return false;
        return true;
    }

    private boolean registerUser(String name, String surname, String email, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO user (imie, nazwisko, mail, haslo) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setString(3, email);
                statement.setString(4, password);
                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Błąd połączenia z bazą danych: " + ex.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
