import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    private JPanel panel1;
    private JTextField userName;
    private JPasswordField userPassword;
    private JLabel login;
    private JLabel haslo;
    private JButton wyjscieButton;
    private JButton zalogujButton;
    private int width = 400, height = 300;

    String user = "admin", password = "admin";

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

                if (userNameInput.equals(user) && userPasswordInput.equals(password)) {
                    dispose();
                    MainSystem mainSystem = new MainSystem();
                    mainSystem.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Podano błędne dane", "Błąd logowania", JOptionPane.ERROR_MESSAGE);
                    userName.setText("");
                    userPassword.setText("");
                }
            }
        });
        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
