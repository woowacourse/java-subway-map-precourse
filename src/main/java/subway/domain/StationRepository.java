package subway.domain;

import subway.exception.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static boolean addStation(Station station) {
        if (checkStationDuplication(station)) {
            return false;
        }
        stations.add(station);
        return true;
    }

    public static boolean deleteStationByName(String name) {
        if(stationBinding(name)) {
            return false;
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static boolean stationBinding(String name) {
        try {
            List<Line> bindings =
                    LineRepository.lines().stream().filter(line -> line.contains(name)).collect(Collectors.toUnmodifiableList());
            if(bindings.size() != 0) {
                throw new StationBindingException(name, bindings);
            }
            return false;
        } catch (StationBindingException e) {
            System.out.println(e.getMessage() + "\n");
            return true;
        }
    }

    public static boolean contains(Station station) {
        return stations().stream().anyMatch(s -> Objects.equals(station, s));
    }

    public static boolean contains(String name) {
        return stations().stream().anyMatch(station -> Objects.equals(station.getName(), name));
    }

    public static Station findStationByName(String name) {
        return stations().stream().filter(station -> Objects.equals(station.getName(), name)).findAny().orElse(null);
    }

    private static boolean checkStationDuplication(Station station) {
        try {
            if (StationRepository.contains(station)) {
                throw new StationDuplicationException(station);
            }

            return false;
        } catch (DuplicationException e) {
            System.out.println(e.getMessage() + "\n");
            return true;
        }
    }
}
