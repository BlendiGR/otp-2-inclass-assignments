import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class

FuelCalculatorTest {

    @Test
    void testCalculateFuel() {
        double result = FuelCalculator.calculateFuel(180, 6.5);
        assertEquals(11.7, result, 0.01);
    }

    @Test
    void testCalculateCost() {
        double result = FuelCalculator.calculateCost(11.7, 2.05);
        assertEquals(23.985, result, 0.01);
    }

    @Test
    void testZeroDistance() {
        double result = FuelCalculator.calculateFuel(0, 6.5);
        assertEquals(0.0, result);
    }
}