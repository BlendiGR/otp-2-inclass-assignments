import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculationRecordTest {

    @Test
    void constructor_shouldStoreAllValuesCorrectly() {
        CalculationRecord calcRecord = new CalculationRecord(
                450.5, 7.8, 1.65, 35.19, 58.0635, "en"
        );

        assertEquals(450.5, calcRecord.getDistance());
        assertEquals(7.8, calcRecord.getConsumption());
        assertEquals(1.65, calcRecord.getPrice());
        assertEquals(35.19, calcRecord.getTotalFuel());
        assertEquals(58.0635, calcRecord.getTotalCost());
        assertEquals("en", calcRecord.getLanguage());
    }

    @Test
    void getters_shouldReturnImmutableValues() {
        CalculationRecord calcRecord = new CalculationRecord(100, 5, 2, 5, 10, "fa");

        assertEquals(100, calcRecord.getDistance());
        assertEquals("fa", calcRecord.getLanguage());
    }
}