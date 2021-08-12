package weather.albo;


import java.util.List;

public class TimeStreamCreator {
    private Long time;


    public void createStream(List<String> towns) {
        TemperatureGetter temperatureGetter = new TemperatureGetter();
        PreviousTemperature previousTemperature = new PreviousTemperature();
        time = System.currentTimeMillis() - 10000;
        while (true) {
            if (time + 10000 <= System.currentTimeMillis()) {
                for (int i = 0; i < towns.size(); i++) {
                    TemperatureUpdater temperatureUpdater = new TemperatureUpdater(towns.get(i), temperatureGetter.getTemperature(towns.get(i)), previousTemperature.getMapWithPreviousTemperature().get(towns.get(i)));
                    createNewThread(temperatureUpdater);
                    previousTemperature.getMapWithPreviousTemperature().put(towns.get(i), temperatureGetter.getTemperature(towns.get(i)));
                }
                time = System.currentTimeMillis();
            }
        }
    }

    public void createNewThread(TemperatureUpdater temperatureUpdater) {
        Thread thread = new Thread(temperatureUpdater);
        thread.start();
    }
}