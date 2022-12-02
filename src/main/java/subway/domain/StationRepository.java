package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validate(station);
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static void validate(Station station) {
        validateStationNameRange(station);
        validateDuplicationStation(station);
    }

    private static void validateStationNameRange(Station station) {
        if (station.getName().length() < 2) {
            throw new IllegalArgumentException("[ERROR] 지하철 역 이름은 두 글자 이상이어야 합니다.");
        }
    }

    private static void validateDuplicationStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 지하철 역 이름은 중복될 수 없습니다.");
        }
    }
}
