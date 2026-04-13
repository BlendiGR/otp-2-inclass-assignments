import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private DatabaseConnection() {
    }

    private static final String DB_HOST = System.getenv().getOrDefault("DB_HOST", "localhost");
    private static final String URL = "jdbc:mariadb://" + DB_HOST + ":3306/fuel_calculator_localization";
    private static final String USER = System.getenv().getOrDefault("DB_USER", "root");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
