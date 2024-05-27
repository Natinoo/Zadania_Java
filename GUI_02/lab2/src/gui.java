import javax.swing.*;

public class gui extends JFrame
{
    private JPanel PenlWelcome;
    private JProgressBar progressBar1;
    private JLabel lblProszeCzekac;
    private int width =400, height= 300;

    public gui()
    {
        super("Laboratorium");
        this.setContentPane(this.PenlWelcome);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        progression();
    }

    private void progression()
    {
        int counter =0;
        while (counter <= 100)
        {
            lblProszeCzekac.setText("Proszę czekać...");
            progressBar1.setValue(counter);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            counter += 5;
        }
        dispose();
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }
}



