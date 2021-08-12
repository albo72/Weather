package weather.albo;

import java.io.*;
import java.net.URISyntaxException;

public class TemperatureGetter {

    public Integer getTemperature(String town) {
        Integer temperature = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Alex\\Desktop\\Java\\Weather\\resources\\" + town + ".txt"));
            temperature = Integer.parseInt(reader.readLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temperature;
    }
}
