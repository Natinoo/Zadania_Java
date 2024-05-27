import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainSystem extends JFrame {
    private JButton wyjscieButton;
    private JButton wylogujButton;
    private JPanel panel1;
    private JButton radioFormButton;
    private JButton checkFormButton;
    private int width = 400, height = 300;

    public MainSystem() {
        super("Logowanie do Systemu");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        wylogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm login = new LoginForm();
                login.setVisible(true);
            }
        });
        radioFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RadioForm radio = new RadioForm();
                radio.setVisible(true);
            }
        });
        checkFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ChecForm check = new ChecForm();
                check.setVisible(true);
            }
        });
    }
}
