package weather.albo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeStreamCreator {
    private Long time;


    public void createStream(List<String> towns) {
        ExecutorService executorService;
        PreviousTemperatureDataBase previousTemperatureDataBase = new PreviousTemperatureDataBase();
        time = System.currentTimeMillis() - 10000;
        while (true) {
            executorService = Executors.newFixedThreadPool(10);
            if (time + 10000 <= System.currentTimeMillis()) {
                for (int i = 0; i < towns.size(); i++) {
                    TemperatureUpdater temperatureUpdater = new TemperatureUpdater(towns.get(i), previousTemperatureDataBase);
                    executorService.submit(temperatureUpdater);
                }
                time = System.currentTimeMillis();
            }
            executorService.shutdown();
        }
    }

    public void createNewThread(TemperatureUpdater temperatureUpdater) {
        Thread thread = new Thread(temperatureUpdater);
        thread.start();
    }
}
