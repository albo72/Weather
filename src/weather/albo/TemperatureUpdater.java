package weather.albo;

public class TemperatureUpdater implements Runnable {
    public static final String CURRENT_TEMP_TEMPLATE = "Текущая температура в %s: %d°C.";
    private final String town;
    private Integer currentTemperature;
    private Integer previousTemperature;

    public TemperatureUpdater(String town, Integer currentTemperature, Integer previousTemperature) {
        this.town = town;
        this.currentTemperature = currentTemperature;
        this.previousTemperature = previousTemperature;

    }

    @Override
    public void run() {
        checkPreviousValueAndOutput(previousTemperature, currentTemperature, town);
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

