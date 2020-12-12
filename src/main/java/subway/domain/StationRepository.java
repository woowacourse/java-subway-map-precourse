package subway.domain;

import subway.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if(stations.stream().anyMatch(o -> o.getName().equals(station.getName()))){
            System.out.println(String.join(" ", Constant.ERROR_PREFIX, Constant.DUPLICATE_STATION_NAME));
            return;
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void printStations(){
        for(int i=0; i<stations.size(); i++){
            System.out.println(String.join(" ", Constant.INFO_PREFIX, stations.get(i).getName()));
        }
    }
}
