import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/biblioteka"; // Adjust your database URL here
    private static final String DB_USER = "root"; // Database username
    private static final String DB_PASSWORD = ""; // Database password

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
