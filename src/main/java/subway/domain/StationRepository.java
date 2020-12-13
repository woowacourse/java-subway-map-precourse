package subway.domain;

import subway.exception.DomainIsNotExistedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = Arrays.asList(
            new Station("교대역"),
            new Station("강남역"),
            new Station("역삼역"),
            new Station("남부터미널역"),
            new Station("양재역"),
            new Station("양재시민의숲역"),
            new Station("매봉역"));

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static Station getStation(String name) throws DomainIsNotExistedException {
        return stations
                .stream()
                .filter(station -> Objects.equals(station.getName(), name))
                .findAny()
                .orElseThrow(DomainIsNotExistedException::new);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean isContainedStationName(String name) {
        return stations.stream().anyMatch(station -> Objects.equals(station.getName(), name));
    }
}
