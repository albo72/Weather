package weather.albo;

public class Main {
    public static void main(String[] args) {
        TownsReader townsReader = new TownsReader();
        Towns towns = new Towns(townsReader.read());
        TimeStreamCreator timeStreamCreator = new TimeStreamCreator();
        timeStreamCreator.createStream(towns.getTowns());
    }
}
