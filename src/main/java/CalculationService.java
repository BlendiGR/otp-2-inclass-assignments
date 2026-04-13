import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalculationService {
    private CalculationService() {
    }


    private static final String INSERT_SQL =
            "INSERT INTO calculation_records (distance, consumption, price, total_fuel, total_cost, language) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    public static void saveCalculation(CalculationRecord calcRecord) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
            pstmt.setDouble(1, calcRecord.getDistance());
            pstmt.setDouble(2, calcRecord.getConsumption());
            pstmt.setDouble(3, calcRecord.getPrice());
            pstmt.setDouble(4, calcRecord.getTotalFuel());
            pstmt.setDouble(5, calcRecord.getTotalCost());
            pstmt.setString(6, calcRecord.getLanguage());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to save calculation: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DatabaseConnection.getConnection();
    }
}
