package subway.station.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.station.exception.CannotFindStationByNameException;
import subway.station.exception.DuplicateStationNameException;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }

    public static Station findByName(String name) {
        return stations.stream()
            .filter(station -> station.getName().equals(name))
            .findAny()
            .orElseThrow(() -> {
                throw new CannotFindStationByNameException(name);
            });
    }

    public static void save(Station station) {
        if (stations.contains(station)) {
            throw new DuplicateStationNameException(station.getName());
        }

        stations.add(station);
    }

    public static void delete(Station station) {
        stations.remove(station);
    }

    public static void deleteAll() {
        stations.clear();
    }
}
