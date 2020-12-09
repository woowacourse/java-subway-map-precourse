package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.line.LineRepository;
import subway.domain.station.exception.CannotDeleteStationAlreadyAddedLineException;
import subway.domain.station.exception.CannotFindStationByNameException;
import subway.domain.station.exception.DuplicateStationNameException;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static Station findStationByName(String name) {
        return stations.stream()
            .filter(station -> station.getName().equals(name))
            .findAny()
            .orElseThrow(() -> {
                throw new CannotFindStationByNameException(name);
            });
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new DuplicateStationNameException(station.getName());
        }

        stations.add(station);
    }

    public static boolean deleteStationByName(String name) {
        Station targetStation = findStationByName(name);
        if (LineRepository.contains(targetStation)) {
            throw new CannotDeleteStationAlreadyAddedLineException(name);
        }

        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAllStation() {
        stations.clear();
    }
}
