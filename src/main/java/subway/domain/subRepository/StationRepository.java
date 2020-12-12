package subway.domain.subRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.Repository;
import subway.domain.Station;

public class StationRepository implements Repository {
    private static final List<Station> stations = new ArrayList<>();
    public static List<Station> getStations() {
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

    public static void add(int position, Station station) {
        stations.add(position, station);
    }

    public static boolean delete(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public List<String> inquiryList() {
        List<String> stationNames = new ArrayList<>();

        for(Station station: stations) {
            stationNames.add(station.getName());
        }
        return stationNames;
    }

    public int size() {
        return this.stations.size();
    }

}
