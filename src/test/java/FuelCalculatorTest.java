import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FuelCalculatorTest {

    @Test
    void calculateFuel_shouldReturnCorrectValue() {
        assertEquals(50.0, FuelCalculator.calculateFuel(500, 10), 0.001);
        assertEquals(0.0, FuelCalculator.calculateFuel(0, 8), 0.001);
        assertEquals(25.5, FuelCalculator.calculateFuel(850, 3), 0.001);
    }

    @Test
    void calculateFuel_withZeroConsumption_shouldReturnZero() {
        assertEquals(0.0, FuelCalculator.calculateFuel(1000, 0), 0.001);
    }

    @Test
    void calculateCost_shouldReturnCorrectValue() {
        assertEquals(75.0, FuelCalculator.calculateCost(50, 1.5), 0.001);
        assertEquals(0.0, FuelCalculator.calculateCost(0, 2.0), 0.001);
        assertEquals(123.45, FuelCalculator.calculateCost(100, 1.2345), 0.001);
    }

    @Test
    void calculateCost_withZeroFuel_shouldReturnZero() {
        assertEquals(0.0, FuelCalculator.calculateCost(0, 10), 0.001);
    }
}