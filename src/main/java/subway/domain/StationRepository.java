package subway.domain;

import exception.AlreadyExistNameException;

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
        if(!isStation(station)){
            throw new AlreadyExistNameException();
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static boolean isStation(Station targetStation){
        for(Station station : stations()){
            if(station.getName().equals(targetStation.getName())){
                return false;
            }
        }
        return true;
    }
}