package subway.domain.subRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import subway.Exception.SubwayRelatedException;
import subway.domain.Station;

public class StationRepository{

    private static final String NO_STATION_EXIST = "역이 존재하지 않습니다.";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public static boolean isRepeatedName(String newName) {
        return stations.
               stream().
               anyMatch(station -> station.getName() == newName);
    }

    public static void addBack(Station station) {
        stations.add(station);
    }

    public static boolean delete(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static List<String> inquiryAllStations() {
        List<String> stationNames = new ArrayList<>();
        for(Station station: stations) {
            stationNames.add(station.getName());
        }
        return stationNames;
    }

    public static Station searchStation(String target) {
        return stations.stream()
               .filter(station -> Objects.equals(station.getName(), target))
               .findFirst()
               .orElseThrow(() -> new SubwayRelatedException(NO_STATION_EXIST));
    }

    public int size() {
        return this.stations.size();
    }

}
