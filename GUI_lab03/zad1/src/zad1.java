import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class zad1 extends JFrame {

    private JPanel panel1;
    private JList list1;
    private JTextField NameField;
    private JTextField MailField;
    private JTextField NumberField;
    private JTextField AdressField;
    private JTextField DateField;
    private JButton saveNewButton;
    private JButton saveExsistingButton;
    int width = 500, height = 500;



    public zad1() {
        super("Zad 1");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(width, height);
        createList();
        saveNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imie = NameField.getText();
                String mail = MailField.getText();
                String telefon = NumberField.getText();
                String adress = AdressField.getText();
                String urodziny = DateField.getText();
            }
        });
    }

    private void createList() {


    }
}
