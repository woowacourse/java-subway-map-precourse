package subway.domain;

import subway.view.OutputViewOfError;
import subway.view.OutputViewOfInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static boolean addStation(Station station) {
        if (!station.isValidNameLength()){
            OutputViewOfError.isNotValidNameLength();
            return false;
        }
        if (isDuplicated(station.getName())) {
            OutputViewOfError.alreadyExistStationError();
            return false;
        }
        stations.add(station);
        return true;
    }

    private static boolean isDuplicated(String name) {
        return stations.stream().anyMatch(station -> station.getName().equals(name));
    }

    public static boolean deleteStation(String name) {
        boolean hasStation = LineRepository.lines.stream()
                                .anyMatch(line -> line.hasStation(name));
        if (hasStation) {
            return false;
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void printStationList() {
        stations.forEach(station -> OutputViewOfInfo.printStations(station.getName()));
    }
}
