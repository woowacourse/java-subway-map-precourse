package subway.domain;

import subway.exception.StationAlreadyExistException;
import subway.exception.StationEmptyException;
import subway.exception.StationNotExistException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void validateAlreadyExists(String stationName){
        if(contains(stationName)){
            throw new StationAlreadyExistException();
        }
    }

    public static boolean contains(String stationName) {
        for(Station station : stations){
            if(station.getName().equals(stationName)){
                return true;
            }
        }
        return false;
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new StationNotExistException();
        }
        stations.add(station);
    }

    public static Station findStation(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        throw new StationNotExistException();
    }

    public static void deleteStation(String name) {
        if (stations.isEmpty()) {
            throw new StationEmptyException();
        }
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                stations.remove(station);
                return;
            }
        }
        throw new StationNotExistException();
    }
}
