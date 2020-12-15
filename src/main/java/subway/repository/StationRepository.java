package subway.repository;

import static subway.console.message.ErrorMessage.EMPTY_STATION;
import static subway.console.message.ErrorMessage.EXIST_STATION;
import static subway.console.message.ErrorMessage.EXIST_STATION_LINE;
import static subway.console.message.ErrorMessage.NOT_EXIST_STATION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.Station;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        if (stations.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_STATION.getMessage());
        }
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validateExistStation(station);
        stations.add(station);
    }

    private static void validateExistStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(EXIST_STATION.getMessage());
        }
    }

    public static boolean deleteStation(Station station) {
        validateExistSection(station);
        return stations.remove(station);
    }

    private static void validateExistSection(Station station) {
        if (SectionRepository.isExistStation(station)) {
            throw new IllegalArgumentException(EXIST_STATION_LINE.getMessage());
        }
    }

    public static Station findByName(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_STATION.getMessage()));
    }
}
