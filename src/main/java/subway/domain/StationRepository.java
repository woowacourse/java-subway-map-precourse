package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public static Optional<Station> getStation(String stationName) {
        List<Station> stationResult = stations.stream()
                .filter(station -> station.getName().equals(stationName))
                .collect(Collectors.toList());
        if (stationResult.size() == 0) {
            return Optional.empty();
        }
        return Optional.of(stationResult.get(0));
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
