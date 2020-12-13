package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> retrieveStation() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        //길이 2이상, 중복 체크
        if (checkNameLength(station.getName()) && !retrieveStation().contains(station)) {
            stations.add(station);
        }
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static boolean checkNameLength(String name) {
        return name.length() >= Constants.MIN_NAME_LENGTH;
    }
}
