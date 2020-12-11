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

    public void addStation(Station station) {
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

    public Station findByName(String station) {
        for (Station stationElement : stations) {
            if (stationElement.getName().equals(station)) {
                return stationElement;
            }
        }
        return null;
    }


    public boolean deleteStationByName(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
