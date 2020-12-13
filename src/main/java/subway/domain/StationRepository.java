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
        if (stations.contains(station)) {
            return;
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        if (stations.removeIf(station -> Objects.equals(station.getName(), name))) {
            LineRepository.deleteStationsOnLineByName(name);
            return true;
        }
        return false;
    }

    public static Station getStationByName(String stationName) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(stationName)) {
                return station;
            }
        }
        return null;
    }
}
