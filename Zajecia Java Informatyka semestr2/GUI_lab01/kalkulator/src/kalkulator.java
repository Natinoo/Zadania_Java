import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class kalkulator extends  JFrame {
    private JPanel panel1;
    private JLabel Tytul;
    private JLabel ikona;
    private JTextField liczbaA;
    private JTextField liczbaB;
    private JButton Sum;
    private JButton divide;
    private JButton button3;
    private JButton diff;
    private JButton Clear;
    private JButton Exit;
    private JLabel podajA;
    private JLabel podajB;
    private JLabel score;
    private JButton multiply;

    public static void main(String[] args) {
        kalkulator calc = new kalkulator();
        calc.setVisible(true);
    }
    private double inputA,inputB, wynik;
    public kalkulator() {
        super("Kalkulator");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 600, height = 640;
        this.setSize(width, height);

    Sum.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            inputA = Double.parseDouble(liczbaA.getText());
            inputB = Double.parseDouble(liczbaB.getText());
            wynik = inputA + inputB;
            score.setText("Suma "+String.valueOf(inputA)+ " + "+ String.valueOf(inputB)+ " = "+ String.valueOf(wynik));
        }
    });
        diff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputA = Double.parseDouble(liczbaA.getText());
                inputB = Double.parseDouble(liczbaB.getText());
                wynik = inputA - inputB;
                score.setText("Róźnica "+String.valueOf(inputA)+ " - "+ String.valueOf(inputB)+ " = "+ String.valueOf(wynik));
            }
        });
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputA = Double.parseDouble(liczbaA.getText());
                inputB = Double.parseDouble(liczbaB.getText());
                wynik = inputA * inputB;
                score.setText("Iloczyn "+String.valueOf(inputA)+ " * "+ String.valueOf(inputB)+ " = "+ String.valueOf(wynik));
            }
        });
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputA = Double.parseDouble(liczbaA.getText());
                inputB = Double.parseDouble(liczbaB.getText());
                if(inputB!=0) {
                    wynik = inputA / inputB;
                    score.setText("Iloraz " + String.valueOf(inputA) + " / " + String.valueOf(inputB) + " = " + String.valueOf(wynik));
                }
                else score.setText("Cholero, nie wolno dzielic przez 0!");
            }
        });

        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczbaA.setText(null);
                liczbaB.setText(null);
            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}



