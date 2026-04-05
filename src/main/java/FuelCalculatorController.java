import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.MessageFormat;
import java.util.Locale;

public class FuelCalculatorController {

    @FXML private Label lblDistance;
    @FXML private Label lblConsumption;
    @FXML private Label lblPrice;
    @FXML private Label lblResult;
    @FXML private TextField txtDistance;
    @FXML private TextField txtConsumption;
    @FXML private TextField txtPrice;
    @FXML private Button btnCalculate;

    private final LocalizationService localizationService = LocalizationService.getInstance();
    private Locale currentLocale = Locale.of("en", "US");

    @FXML
    public void initialize() {
        setLanguage(Locale.of("en", "US"));
    }

    public void setLanguage(Locale locale) {
        currentLocale = locale;
        localizationService.setCurrentLanguage(locale.getLanguage());

        lblDistance.setText(localizationService.getString("distance.label"));
        lblConsumption.setText(localizationService.getString("consumption.label"));
        lblPrice.setText(localizationService.getString("price.label"));
        btnCalculate.setText(localizationService.getString("calculate.button"));
        lblResult.setText("");

        boolean isRTL = locale.getLanguage().equals("fa");
        NodeOrientation orientation = isRTL
                ? NodeOrientation.RIGHT_TO_LEFT
                : NodeOrientation.LEFT_TO_RIGHT;

        if (lblDistance.getScene() != null) {
            lblDistance.getScene().getRoot().setNodeOrientation(orientation);
        }
    }

    @FXML private void handleEN() { setLanguage(Locale.of("en", "US")); }
    @FXML private void handleFR() { setLanguage(Locale.of("fr", "FR")); }
    @FXML private void handleJP() { setLanguage(Locale.of("ja", "JP")); }
    @FXML private void handleIR() { setLanguage(Locale.of("fa", "IR")); }

    @FXML
    private void handleCalculate() {
        try {
            double distance    = Double.parseDouble(txtDistance.getText().trim());
            double consumption = Double.parseDouble(txtConsumption.getText().trim());
            double price       = Double.parseDouble(txtPrice.getText().trim());

            if (distance < 0 || consumption < 0 || price < 0) {
                lblResult.setText(localizationService.getString("invalid.input"));
                return;
            }

            double totalFuel = FuelCalculator.calculateFuel(distance, consumption);
            double totalCost = FuelCalculator.calculateCost(totalFuel, price);

            String resultTemplate = localizationService.getString("result.label");
            lblResult.setText(MessageFormat.format(resultTemplate,
                    String.format("%.2f", totalFuel),
                    String.format("%.2f", totalCost)));

            CalculationRecord record = new CalculationRecord(
                    distance, consumption, price, totalFuel, totalCost,
                    currentLocale.getLanguage());
            CalculationService.saveCalculation(record);

        } catch (NumberFormatException e) {
            lblResult.setText(localizationService.getString("invalid.input"));
        }
    }
}
