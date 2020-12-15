package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station findStationByName(String name) {
        for (Station station : stations()) {
            if (station.isSameName(name)) {
                return station;
            }
        }
        return null;
    }

    public static List<String> getStationsWithFormatting() {
        return stations.stream().map(Station::formatName).collect(Collectors.toList());
    }
}
