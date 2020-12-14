package subway.domain;

import subway.domain.exception.NonExistingStationException;
import subway.domain.validator.StationValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static void addStation(Station station) {
        StationValidator.checkNotExistingName(stations.contains(station));
        stations.add(station);
    }

    public static void remove(Station station) {
        StationValidator.checkIsNotOnLine(station);
        stations.remove(station);
    }

    public static List<String> getStationNames() {
        return stations.stream()
                .map(Station::toString)
                .collect(Collectors.toList());
    }

    public static Station getByName(Name name) {
        return stations.stream()
                .filter(station -> station.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new NonExistingStationException());
    }
}
