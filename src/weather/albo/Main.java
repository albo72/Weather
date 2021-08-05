package weather.albo;

public class Main {
    public static void main(String[] args) {
        TownsReader townsReader = new TownsReader();
        Towns towns = new Towns(townsReader.read());
        ThreadCreator threadCreator = new ThreadCreator();
        threadCreator.createThreadsWithWeather(towns.getTowns());
    }
}
