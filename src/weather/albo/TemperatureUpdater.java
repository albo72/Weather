package weather.albo;

public class TemperatureUpdater implements Runnable {
    private final String town;

    public TemperatureUpdater(String town) {
        this.town = town;
    }

    @Override
    public void run() {
        TemperatureGetter temperatureGetter = new TemperatureGetter();
        Integer previousTemperature = null;
        while (true) {
            int currentTemperature = temperatureGetter.getTemperature(town);
            checkPreviousValueAndOutput(previousTemperature, currentTemperature, town);
            previousTemperature = currentTemperature;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkPreviousValueAndOutput(Integer previousTemperature, int currentTemperature, String city) {
        if (previousTemperature == null) {
            System.out.printf("Текущая температура в %s: %d°C. \n", city, currentTemperature);
        } else if (previousTemperature < currentTemperature) {
            int difference = currentTemperature - previousTemperature;
            System.out.printf("Текущая температура в %s: %d°C. Она повысилась на %d°C. \n", city, currentTemperature, difference);
        } else if (previousTemperature > currentTemperature) {
            int difference = previousTemperature - currentTemperature;
            System.out.printf("Текущая температура в %s: %d°C. Она понизилась на %d°C. \n", city, currentTemperature, difference);
        } else {
            System.out.printf("Текущая температура в %s: %d°C. Она осталась прежней. \n", city, currentTemperature);
        }
    }
}

