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

    public static boolean isExistEqualName(String newName) {
        for(Station station: stations) {
            if (station.equalWith(newName)) {
               return true;
            }
        }
        return false;
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static List<String> inquiryList() {
        List<String> stationNames = new ArrayList<>();

        for(Station station: stations) {
            stationNames.add(station.getName());
        }
        return stationNames;
    }


}
