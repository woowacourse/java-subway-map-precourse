package subway.domain;

import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final String NAME = "역";
    private static final int NONE = -1;

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static boolean addStation(Station station) {
        if (!station.isNameMoreThan2Letters()) {
            OutputView.printNameLengthErrorMessage(NAME, station.getName());
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
        return stations.removeIf(station -> Objects.equals(station.getName(), name) && !isStationHasLine(station));
    }

    private static boolean isStationHasLine(Station station) {
        for (Line line : LineRepository.lines()) {
            if (line.getPath().isStationInLine(station)) {
                return true;
            }
        }
        return false;
    }

    public static void addStations(List<Station> stations) {
        stations.forEach(StationRepository::addStation);
    }

    public static boolean hasDuplicatedStation(Station checkedStation) {
        for (Station station : stations) {
            if (station.getName().equals(checkedStation.getName())) {
                return true;
            }
        }
        return false;
    }

    public static void printStations() {
        for (Station station : stations) {
            OutputView.printWithInformationMark(station.getName());
        }
    }

    private static int getIndexOfStationIfExist(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return stations.indexOf(station);
            }
        }
        return NONE;
    }

    public static Station getStation(String name) {
        if (getIndexOfStationIfExist(name) == NONE) {
            Station station = new Station(name);
            addStation(station);
            return station;
        }
        return stations.get(getIndexOfStationIfExist(name));
    }
}
