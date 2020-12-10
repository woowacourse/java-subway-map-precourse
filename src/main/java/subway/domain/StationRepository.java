package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

    public List findAll() {
        Iterator<Station> iter = stations.iterator();
        List<String> stationNameList = new ArrayList<>();
        while (iter.hasNext()) {
            stationNameList.add(iter.next().getName());
        }
        return stationNameList;
    }

    public Station findByName(String lineName) {
        for (Station station : stations) {
            if (station.getName().equals(lineName)) {
                return station;
            }
        }
        System.out.println("없는 역 입니다");
        return null;
    }


    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
