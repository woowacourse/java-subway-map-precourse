package subway.domain;

import java.util.*;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean contains(String name) {
        for(int i=0; i<stations().size(); i++) {
            final Station station = stations().get(i);
            if(station.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static Optional<Station> findByName(String name) {
        for(int i=0; i<stations().size(); i++) {
            final Station station = stations().get(i);
            if(station.getName().equals(name)) {
                return Optional.of(station);
            }
        }
        return Optional.empty();
    }
}
