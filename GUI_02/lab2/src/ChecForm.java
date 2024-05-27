import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChecForm extends JFrame{
    private JButton wyjscieButton;
    private JButton wsteczButton;
    private JPanel PanelCheck;
    private JCheckBox javaPrice3500CheckBox;
    private JCheckBox pythonPrice4500CheckBox;
    private JCheckBox cPrice4000CheckBox;
    private JCheckBox cPrice5000CheckBox;
    private int width = 400, height = 300;

    public ChecForm() {
        super("Radio Panel");
        this.setContentPane(this.PanelCheck);
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
        wsteczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainSystem main = new MainSystem();
                main.setVisible(true);
            }
        });
    }
}
