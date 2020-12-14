package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import subway.exception.StationErrorMessage;

public class StationRepository implements StationErrorMessage {
    private static final List<Station> stations = new ArrayList<>();
    private static final int STATION_NAME_LENGTH_LIMIT = 2;
    private static final String SYMBOL_INFO = "[INFO] ";

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(String stationName) {
        Station newStation = getAddStationName(stationName);
        stations.add(newStation);
    }

    private static Station getAddStationName(String stationName) {
        validateStationNameAdded(stationName);
        return new Station(stationName);
    }

    private static void validateStationNameAdded(String stationName) {
        if (stationName.length() < STATION_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ERROR_INVALID_STATION_NAME_LENGTH);
        }
        if (isStationInRepository(stationName)) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_STATION_NAME_IN_REPOSITORY);
        }
    }

    public static void deleteStation(String stationName) {
        validateStationNameDeleted(stationName);
        stations().removeIf(station -> Objects.equals(station.getName(), stationName));
    }

    private static void validateStationNameDeleted(String stationName) {
        if (!isStationInRepository(stationName)) {
            throw new IllegalArgumentException(ERROR_NO_STATION_IN_REPOSITORY);
        }
        if (hasLine(stationName)) {
            throw new IllegalArgumentException(ERROR_HAS_LINE);
        }
    }

    private static boolean hasLine(String stationName) {
        Station stationSelected = stations().stream().
            filter(station -> station.getName().equals(stationName)).findFirst().get();
        return stationSelected.isEnrolled();
    }

    private static boolean isStationInRepository(String stationName) {
        return stations().stream().anyMatch(station -> station.getName().equals(stationName));
    }

    public static void displayAllStations() {
        Iterator iterator = stations().iterator();
        while (iterator.hasNext()) {
            Station station = (Station)iterator.next();
            System.out.println(SYMBOL_INFO + station.getName());
        }
        if (stations().size() == 0) {
            System.out.println(MESSAGE_NO_STATION);
        }
    }
}
