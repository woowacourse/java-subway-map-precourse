package subway.domain;

import subway.view.OutputView;

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
        if (!station.isNameMoreThan2Letters()) {
            OutputView.printNameLengthErrorMessage(station.getName());
            return false;
        }
        if (hasDuplicatedStation(station)) {
            OutputView.printDuplicatedErrorMessage(station.getName());
            return false;
        }
        stations.add(station);
        return true;
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name) && !station.isStationHasLine());
    }

    public static void addStations(List<Station> stations) {
        stations.forEach(StationRepository::addStation);
    }

    public static boolean hasDuplicatedStation(Station station) {
        return stations.contains(station);
    }

    public static void printStations() {
        for (Station station : stations) {
            OutputView.printWithInformationMark(station.getName());
        }
    }
}
