package weather.albo;

import java.util.HashMap;
import java.util.Map;

public class PreviousTemperature {
    private Map<String, Integer> mapWithPreviousTemperature = new HashMap<>();

    public Map<String, Integer> getMapWithPreviousTemperature() {
        return mapWithPreviousTemperature;
    }
}
