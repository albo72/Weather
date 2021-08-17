package weather.albo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PreviousTemperatureDataBase {
    private Map<String, Integer> mapWithPreviousTemperature = new ConcurrentHashMap<>();

    public Map<String, Integer> getMapWithPreviousTemperature() {
        return mapWithPreviousTemperature;
    }
}
