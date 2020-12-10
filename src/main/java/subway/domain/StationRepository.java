package subway.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class StationRepository {

    private static final Set<Station> stations = new HashSet<>();

    public static Set<Station> stations() {
        return Collections.unmodifiableSet(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public void getLine() {
        Iterator<Station> iter = stations.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().getName());
        }
    }


    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
