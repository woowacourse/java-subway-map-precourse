package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.console.message.ErrorMessage;
import subway.domain.Station;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validateExistStation(station);
        stations.add(station);
    }

    private static void validateExistStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_STATION);
        }
    }

    public static boolean deleteStation(Station station) {
        validateExistSection(station);
        return stations.remove(station);
    }

    private static void validateExistSection(Station station) {
        if (SectionRepository.isExistStation(station)) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_STATION_LINE);
        }
    }

    public static Station findByName(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_STATION));
    }
}
