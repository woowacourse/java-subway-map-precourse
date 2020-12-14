package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static Station getEqualsStation(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return station;
            }
        }
        return new Station(stationName);
    }

    public static boolean deleteStation(String name) {
        LineRepository.validateLineInStationCheck(name);
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static List<Station> getStations() {
        return stations;
    }
}
