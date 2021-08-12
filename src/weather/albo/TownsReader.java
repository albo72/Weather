package weather.albo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class TownsReader {

    public List<String> read() {
        Properties properties = new Properties();
        List<String> listOfTowns = new ArrayList<>();
        try {
            properties.load(new FileReader(new File(this.getClass().getClassLoader().getResource("Towns.properties").toURI())));
            String[] towns = properties.getProperty("towns").split(",");
            listOfTowns.addAll(Arrays.asList(towns));
        } catch (IOException | URISyntaxException e ) {
            e.printStackTrace();
        }
        return listOfTowns;
    }
}
