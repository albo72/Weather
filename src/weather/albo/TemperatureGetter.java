package weather.albo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TemperatureGetter {

    public Integer getTemperature(String town) {
        Integer temperature = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Alex\\Desktop\\Java\\Weather\\resources\\" + town + ".txt"));
            temperature = Integer.parseInt(reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return temperature;
    }
}
