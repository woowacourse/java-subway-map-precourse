package subway.domain;

import validator.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final String NEW_LINE = "\n";

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static Station getStation(String stationName) {
        for (Station station : stations()) {
            if (Objects.equals(station.getName(), stationName)) {
                return station;
            }
        }
        return null;
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean isStationExist (String name) {
        for (Station station : stations()) {
            String stationName = station.getName();
            if (stationName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void isValidStationName(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_NAME_OVER_TWO);
        }
        if (isStationExist(name)) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_NAME_EXISTS);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Station station : stations()) {
            sb.append("[INFO] " + station + NEW_LINE);
        }
        return sb.toString();
    }
}
