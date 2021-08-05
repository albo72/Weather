package weather.albo;

import java.util.List;

public class ThreadCreator {
    public void createThreadsWithWeather(List<String> towns) {
        for (int i = 0; i < towns.size(); i++) {
            TemperatureUpdater temperatureUpdater = new TemperatureUpdater(towns.get(i));
            Thread thread = new Thread(temperatureUpdater);
            thread.start();
        }
    }
}
