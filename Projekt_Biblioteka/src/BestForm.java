import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BestForm extends JFrame {
    private int width = 1000, height = 1000;
    private JPanel panel1;
    private JPanel panelRadio;
    private JButton wyjscieButton;
    private JButton wsteczButton;
    private int loggedInUserId; // ID zalogowanego użytkownika

    public BestForm(int userId) {
        super("Bestsellery");
        this.loggedInUserId = userId; // Przechowywanie ID zalogowanego użytkownika
        this.setContentPane(this.panelRadio);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        wsteczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainSystem main = new MainSystem(loggedInUserId); // Przekazanie ID użytkownika z powrotem do MainSystem
                main.setVisible(true);
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
