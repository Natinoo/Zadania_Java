import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioForm extends JFrame{
    private JButton wyjscieButton;
    private JButton wsteczButton;
    private JPanel panelRadio;
    private JRadioButton linuxRadioButton;
    private JRadioButton windowsRadioButton;
    private JRadioButton macintoshRadioButton;
    private JLabel iconLabel;
    private JButton OKButton;
    private int width = 400, height = 370;

    private ImageIcon iconLinux = new ImageIcon(getClass().getResource("icons8-linux-48.png"));
    private ImageIcon iconWindows = new ImageIcon(getClass().getResource("icons8-windows-48.png"));
    private ImageIcon iconApple = new ImageIcon(getClass().getResource("icons8-apple-48.png"));

    private static ImageIcon resize(ImageIcon src,int destWidth, int destHeight){
        return new ImageIcon(src.getImage().getScaledInstance(destWidth,destHeight, Image.SCALE_SMOOTH));
    }

    public RadioForm() {
        super("Radio Panel");
        this.setContentPane(this.panelRadio);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        wsteczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainSystem main = new MainSystem();
                main.setVisible(true);
            }
        });
        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              dispose();
            }
        });
        linuxRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(linuxRadioButton.isSelected())
                {
                    iconLabel.setIcon(resize(iconLinux,120,120));
                }
            }
        });
        windowsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(windowsRadioButton.isSelected())
                {
                    iconLabel.setIcon(resize(iconWindows,120,120));
                }
            }
        });
        macintoshRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(macintoshRadioButton.isSelected())
                {
                    iconLabel.setIcon(resize(iconApple,120,120));
                }
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(linuxRadioButton.isSelected()){
                    JOptionPane.showMessageDialog(null, "Wybrano Linuxa");
                }
                if(windowsRadioButton.isSelected()){
                    JOptionPane.showMessageDialog(null, "Wybrano Windowsa");
                }
                if(macintoshRadioButton.isSelected()){
                    JOptionPane.showMessageDialog(null, "Wybrano macintosha");
                }
            }
        });
    }
}
