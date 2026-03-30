public class FuelCalculator {

    public static double calculateFuel(double distanceKm, double consumptionPer100Km) {
        return (consumptionPer100Km / 100.0) * distanceKm;
    }

    public static double calculateCost(double totalFuelLiters, double pricePerLiter) {
        return totalFuelLiters * pricePerLiter;
    }
}