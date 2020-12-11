package subway.domain;

import subway.enums.Criteria;
import subway.enums.InitialStations;

import java.util.*;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean isNameDuplication(String name) {
        return stations.stream()
                .map(Station::getName)
                .anyMatch(station -> station.equals(name));
    }

    public static boolean isNameLengthUnderCriteria(String name) {
        return name.trim().length() < Criteria.MINIMUM_NAME_LENGTH.getValue();
    }

    public static Station getStationByName(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .get();
    }

    public static void initializeStations() {
        Arrays.stream(InitialStations.values())
                .map(InitialStations::getName)
                .map(Station::new)
                .forEach(StationRepository::addStation);
    }
}
