package subway.domain;

import exception.AlreadyExistNameException;
import exception.NoExistStationNameException;
import exception.UsedStationException;

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
        if (!isStation(station.getName())) {
            throw new AlreadyExistNameException();
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        if (getStation(name).isLineStation()) {
            throw new UsedStationException();
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean isStation(String name) {
        for (Station station : stations()) {
            if (station.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public static Station getStation(String name) {
        for (Station station : stations()) {
            if (station.getName().equals(name))
                return station;
        }
        throw new NoExistStationNameException();
    }
}