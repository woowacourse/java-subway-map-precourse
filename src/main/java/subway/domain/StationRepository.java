package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import subway.exception.DuplicatedStationNameException;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (containsStation(station)) {
            throw new DuplicatedStationNameException(station.getName());
        }

        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean containsStation(Station station) {
        return containsStation(station.getName());
    }
    
    private static boolean containsStation(String name) {
        return stations.stream()
                .anyMatch(streamStation -> name.equals(streamStation.getName()));
    }
}
