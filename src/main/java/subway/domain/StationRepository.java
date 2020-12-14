package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.view.InputView;
import subway.view.OutputView;

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

    public static void add(InputView inputView, String stationMessage) {
        OutputView.printAddActionMessage(stationMessage);
        String newStationName = inputView.getInput();
        if (Station.validateAddStationName(newStationName, stationMessage)) {
            Station newStation = new Station(newStationName);
            StationRepository.addStation(newStation);
        }
        OutputView.printAddActionFinishMessage(stationMessage);
    }

    public static void delete(InputView inputView, String stationMessage) {
        OutputView.printDeleteActionMessage(stationMessage);
        String deleteStationName = inputView.getInput();
        if (Station.validateDeleteStationName(deleteStationName, stationMessage)) {
            StationRepository.deleteStation(deleteStationName);
            OutputView.printDeleteActionFinishMessage(stationMessage);
        }
    }

    public static boolean validateNewName(String name) {
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public static void printList(String stationMessage) {
        OutputView.printList(stationMessage, getStationNameList());
    }

    private static List<String> getStationNameList() {
        List<String> stationNames = new ArrayList<String>();
        for (int i = 0; i < stations.size(); i++) {
            stationNames.add(stations.get(i).getName());
        }
        return stationNames;
    }
}
