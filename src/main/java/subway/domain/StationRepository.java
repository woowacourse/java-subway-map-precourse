package subway.domain;

import subway.util.ValidateUtil;

import java.util.List;

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

    public static List<String> getStationNames() {
        return stations.stationNames();
    }

    public static boolean isPresentStation(String name) {
        return stations.isPresentStation(StationFactory.makeStation(name));
    }

    public static Station findStationByName(String name) {
        return stations.findStation(name);
    }
}
