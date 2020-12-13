package subway.domain;

public class StationRepository {
    private static final Stations stations = new Stations();

    public static Stations stations() {
        return stations;
    }

    public static void addStation(Station station) {
        stations.addStation(station);
    }

    public static boolean deleteStation(String name) {
        return stations.deleteStation(name);
    }
}
