package weather.albo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class TemperatureGetter {

    public Integer getTemperature(String town) {
        Integer temperature = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(this.getClass().getClassLoader().getResource(town + ".txt").toURI())));
            temperature = Integer.parseInt(reader.readLine());

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return temperature;
    }
}
