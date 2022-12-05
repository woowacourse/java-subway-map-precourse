package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private static final int STATION_NAME_MINIMUM_LENGTH = 2;
    private static final String ERROR_STATION_NAME_LENGTH = "지하철 역 이름은 두 글자 이상이어야 합니다.";
    private static final String ERROR_STATION_NAME_DUPLICATION = "지하철 역 이름은 중복될 수 없습니다.";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (validate(station)) {
            stations.add(station);
        }
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static boolean validate(Station station) {
        return (validateStationNameRange(station) && validateDuplicationStation(station));
    }

    private static boolean validateStationNameRange(Station station) {
        if (station.getName().length() < STATION_NAME_MINIMUM_LENGTH) {
            throw new IllegalArgumentException(ERROR_STATION_NAME_LENGTH);
        }
        return true;
    }

    private static boolean validateDuplicationStation(Station station) {
        if (stations().stream().anyMatch(name -> name.getName().equals(station.getName()))) {
            throw new IllegalArgumentException(ERROR_STATION_NAME_DUPLICATION);
        }
        return true;
    }
}
