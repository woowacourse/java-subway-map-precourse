package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> retrieveStation() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(String name) {
        //길이 2이상, 중복 체크
        if (checkNameLength(name) && !checkNameInStations(name)) {
            stations.add(new Station(name));
            return;
        }

        throw new IllegalArgumentException();
    }

    public static void deleteStation(String name) {

        if (checkNameInStations(name) && !checkStationInLines(name)) {
            stations.removeIf(station -> Objects.equals(station.getName(), name));
            return;
        }

        throw new IllegalArgumentException();
    }

    public static boolean checkStationInLines(String name) {
        List<Line> lines = LineRepository.retrieveLine();

        for (Line line : lines) {
            if (line.isContain(name)) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkNameLength(String name) {
        return name.length() >= Constants.MIN_NAME_LENGTH;
    }

    public static boolean checkNameInStations(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}
