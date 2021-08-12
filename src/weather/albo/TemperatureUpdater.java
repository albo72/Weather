package weather.albo;

public class TemperatureUpdater implements Runnable {
    private static final String CURRENT_TEMP_TEMPLATE = "Текущая температура в %s: %d°C.";
    private final String town;
    private PreviousTemperatureDataBase previousTemperatureDataBase;

    public TemperatureUpdater(String town, PreviousTemperatureDataBase previousTemperatureDataBase) {
        this.town = town;
        this.previousTemperatureDataBase = previousTemperatureDataBase;
    }

    @Override
    public void run() {
        TemperatureGetter temperatureGetter = new TemperatureGetter();
        Integer previousTemperature = previousTemperatureDataBase.getMapWithPreviousTemperature().get(town);
        Integer currentTemperature = temperatureGetter.getTemperature(town);
        checkPreviousValueAndOutput(previousTemperature, currentTemperature, town);
        previousTemperatureDataBase.getMapWithPreviousTemperature().put(town,currentTemperature);
    }

    private void checkPreviousValueAndOutput(Integer previousTemperature, int currentTemperature, String city) {
        if (previousTemperature == null) {
            System.out.printf(CURRENT_TEMP_TEMPLATE + " \n", city, currentTemperature);
        } else if (previousTemperature < currentTemperature) {
            int difference = currentTemperature - previousTemperature;
            System.out.printf(CURRENT_TEMP_TEMPLATE + " Она повысилась на %d°C. \n", city, currentTemperature, difference);
        } else if (previousTemperature > currentTemperature) {
            int difference = previousTemperature - currentTemperature;
            System.out.printf(CURRENT_TEMP_TEMPLATE + " Она понизилась на %d°C. \n", city, currentTemperature, difference);
        } else {
            System.out.printf(CURRENT_TEMP_TEMPLATE + " Она осталась прежней. \n", city, currentTemperature);
        }
    }
}

