import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalculationService {

    private static final String INSERT_SQL =
            "INSERT INTO calculation_records (distance, consumption, price, total_fuel, total_cost, language) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    public static void saveCalculation(CalculationRecord record) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
            pstmt.setDouble(1, record.getDistance());
            pstmt.setDouble(2, record.getConsumption());
            pstmt.setDouble(3, record.getPrice());
            pstmt.setDouble(4, record.getTotalFuel());
            pstmt.setDouble(5, record.getTotalCost());
            pstmt.setString(6, record.getLanguage());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to save calculation: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DatabaseConnection.getConnection();
    }
}
