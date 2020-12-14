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
        validateEqualsCheck(station);
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void validateEqualsCheck(Station station) {
        for (Station value : stations) {
            if (value.getName().equals(station.getName())) {
                throw new IllegalArgumentException("[ERROR] 이미 등록된 역은 등록할 수 없습니다.");
            }
        }
    }

}
