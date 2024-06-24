import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MainSystem extends JFrame {
    private JButton wyjscieButton;
    private JButton wylogujButton;
    private JPanel panel1;
    private JButton radioFormButton;
    private JButton checkFormButton;
    private JLabel topka;
    private JButton dodajKsiążkiButton;
    private JButton użytkownicyButton;
    private int width = 750, height = 660;
    private int loggedInUserId;

    public MainSystem(int userId) {
        super("Biblioteka.exe");
        this.loggedInUserId = userId;
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();

            String query = "SELECT user_type FROM user WHERE ID= ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, loggedInUserId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String user_type = resultSet.getString("user_type");

                if (user_type.equals("admin")) {
                    użytkownicyButton.setVisible(true);
                    dodajKsiążkiButton.setVisible(true);
                } else {
                    użytkownicyButton.setVisible(false);
                    dodajKsiążkiButton.setVisible(false);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

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
                RadioForm radio = new RadioForm(loggedInUserId);
                radio.setVisible(true);
            }
        });

        checkFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ChecForm check = new ChecForm(loggedInUserId);
                check.setVisible(true);
            }
        });


        użytkownicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                uzytkownik user = new uzytkownik(loggedInUserId);
                user.setVisible(true);
            }
        });

        dodajKsiążkiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ksiazki book = new ksiazki(loggedInUserId);
                book.setVisible(true);
            }
        });
    }
}
