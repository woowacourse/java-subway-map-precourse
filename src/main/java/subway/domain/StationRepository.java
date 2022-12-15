package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.util.ExceptionMessage;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static Station findStationBy(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_STATION_NAME.getMessage()));
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }


    public static void validateDuplicatedStationName(String newStationName) {
        if (hasDuplicatedStationName(newStationName)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_STATION_NAME.getMessage());
        }
    }

    private static boolean hasDuplicatedStationName(String newStationName) {
        return getAllStationNames().contains(newStationName);
    }

    private static List<String> getAllStationNames() {
        return stations.stream().map(Station::getName).collect(Collectors.toList());
    }

}
