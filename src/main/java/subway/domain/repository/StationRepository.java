package subway.domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.domain.Station;

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

    public static boolean findNoStation(String name) {
        return stations.stream().noneMatch(station -> Objects.equals(station.getName(), name));
    }

    public static List<Station> readStation(String name) {
        return StationRepository.stations().stream().filter(station ->
            station.getName() == name).collect(Collectors.toList());
    }
}
