package weather.albo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TownsReader {
    private final String pathToProperties = "C:\\Users\\Alex\\Desktop\\Java\\Weather\\resources\\weather.albo.Towns.properties";

    public List<String> read() {
        Properties properties = new Properties();
        List<String> listOfTowns = new ArrayList<>();
        try {
            properties.load(new FileInputStream(pathToProperties));
            String[] towns = properties.getProperty("towns").split(",");
            for (String town : towns) {
                listOfTowns.add(town);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfTowns;
    }
}
