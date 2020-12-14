package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.console.message.ErrorMessage;
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
        if (SectionRepository.isExistStation(name)) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_STATION_LINE);
        }
        if (!isExist(name)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_STATION);
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean isExist(String name) {
        return stations.stream().anyMatch(station -> station.getName().equals(name));
    }

    public static Station findOne(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_STATION));
    }
}
