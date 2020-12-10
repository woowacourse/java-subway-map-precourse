package subway.domain;

import subway.view.StationMessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    static {
        addStation(new Station("교대역"));
        addStation(new Station("강남역"));
        addStation(new Station("역삼역"));
        addStation(new Station("남부터미널"));
        addStation(new Station("양재역"));
        addStation(new Station("양재시민의숲역"));
        addStation(new Station("매봉역"));
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static boolean hasName(String name) {
        return StationRepository.stations().stream()
                .map(Station::getName)
                .anyMatch(stationName -> stationName.equals(name));
    }

    public static void validateDuplicate(String name) throws IllegalArgumentException {
        if (hasName(name)) {
            throw new IllegalArgumentException(StationMessages.DUPLICATE_NAME_ERROR.getMessage());
        }
    }

    public static void validateRegistration(String name) throws IllegalArgumentException {
        if (!hasName(name)) {
            throw new IllegalArgumentException(StationMessages.UNREGISTERED_NAME_ERROR.getMessage());
        }
    }
}
