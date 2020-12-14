package subway.domain;

import subway.util.ValidateUtil;

public class StationRepository {
    private static final Stations stations = new Stations();

    public static Stations stations() {
        return stations;
    }

    public static void addStation(Station station) {
        stations.addStation(station);
    }

    public static void deleteStation(String name) {
        ValidateUtil.canDeleteStation(stations.findStation(name));
        stations.deleteStation(name);
    }
}
