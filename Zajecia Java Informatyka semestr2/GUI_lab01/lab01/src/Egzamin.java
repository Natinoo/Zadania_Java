import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Egzamin extends JFrame
{
    private JPanel panel1;
    private JPanel panelLabel;
    private JLabel Srodek;
    private JLabel Header;
    private JButton button3;
    private JButton button1;
    private JButton button2;

    public static void main(String[] args)
    {
        Egzamin egzamin = new Egzamin();
        egzamin.setVisible(true);
    }
    public Egzamin()
    {
        super("Moje pierwsze okno");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 1000, height = 1000;
        this.setSize(width,height);
        //this.pack();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Podaj imię: ");

                JOptionPane.showMessageDialog(null,"Witaj "+name);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3.setText(new Date().toString());
            }
        });
    }
}
