package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final String NEW_LINE = "\n";

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static Station findByName(String name) {
        for (Station station : stations()) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        return null;
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean contains(String findStation) {
        return stations.stream()
                .anyMatch(station -> station.getName().equals(findStation));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Station station : stations()) {
            sb.append("[INFO] " + station + NEW_LINE);
        }
        return sb.toString();
    }
}
