import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example extends JFrame {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton button1;
    private JTable Film;

    int width = 400, height = 400;

    public Example() {
        super("Test");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(width, height);

        createTable();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedComboBox = (String) comboBox1.getSelectedItem();
                JOptionPane.showMessageDialog(Example.this, "Wybrano opcje " + selectedComboBox);
            }
        });


    }

    private void createTable() {
        Object[][] date = {
                {"Film 1", 2024, 9.15, 4545464},
                {"Film 2", 2014, 8.24, 4545345},
                {"Film 3", 2021, 2.06, 1234345}
        };
        Film.setModel(new DefaultTableModel(
                date,
                new String[]{"Tytuł", "Rok produkcji", "Ranking", "ID filmu"}
        ));

        TableColumnModel tableColumnModel = Film.getColumnModel();
        tableColumnModel.getColumn(0).setMinWidth(200);
    }
}


