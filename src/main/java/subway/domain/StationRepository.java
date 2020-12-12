package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final Set<String> stationNames = new HashSet<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
        stationNames.add(station.getName());
    }

    public static boolean deleteStation(String name) {
        stationNames.remove(name);
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Set<String> stationNames(){
        return Collections.unmodifiableSet(stationNames);
    }

    public static Station findStation(String name){
        return stations.stream().filter(item -> Objects.equals(item.getName(), name)).findFirst().get();
    }
}
