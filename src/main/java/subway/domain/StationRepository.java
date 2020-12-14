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

    public static void addStation(Station station) {
        //길이 2이상, 중복 체크
        if (checkNameLength(station) && !checkContainInStations(station.getName())) {
            stations.add(station);
            return;
        }

        throw new IllegalArgumentException();
    }

    public static void deleteStation(String name) {

        if (checkContainInStations(name) && !checkContainInLines(name)) {
            stations.removeIf(station -> Objects.equals(station.getName(), name));
            return;
        }

        throw new IllegalArgumentException();
    }

    private static boolean checkContainInLines(String name) {
        List<Line> lines = LineRepository.retrieveLine();

        for (Line line : lines) {
            if (line.isContain(name)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkNameLength(Station station) {
        return station.getName().length() >= Constants.MIN_NAME_LENGTH;
    }

    private static boolean checkContainInStations(String name) {
        for (Station curStation : stations) {
            if (curStation.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}
