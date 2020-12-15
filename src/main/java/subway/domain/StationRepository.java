package subway.domain;

import subway.Exception.StationException.CanNotFindStationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final String NEW_LINE = "\n";
    private static final String PRINT_INFO = "[INFO] ";

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station findByName(String name) {
        return stations().stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .orElseThrow(CanNotFindStationException::new);
    }

    public static boolean contains(String findStation) {
        return stations.stream()
                .anyMatch(station -> station.getName().equals(findStation));
    }

    public static boolean isValidStationNameLength(String name) {
        return name.length() < Station.MIN_STATION_NAME_LENGTH;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Station station : stations()) {
            sb.append(PRINT_INFO + station + NEW_LINE);
        }
        return sb.toString();
    }
}
