package subway.domain;

import subway.domain.exception.ExistentNameException;
import subway.domain.exception.UnvalidNameLengthException;
import subway.domain.exception.NonExistentNameException;
import subway.domain.exception.RegisteredStationException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;
    private static final int MINIMUM_LENGTH = 2;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void add(InputView inputView, String stationMessage) {
        OutputView.printAddActionMessage(stationMessage);
        String newStationName = inputView.getInput();
        if (validateAddStationName(newStationName, stationMessage)) {
            Station newStation = new Station(newStationName);
            StationRepository.addStation(newStation);
        }
        OutputView.printAddActionFinishMessage(stationMessage);
    }

    public static void delete(InputView inputView, String stationMessage) {
        OutputView.printDeleteActionMessage(stationMessage);
        String deleteStationName = inputView.getInput();
        if (validateDeleteStationName(deleteStationName)) {
            StationRepository.deleteStation(deleteStationName);
            OutputView.printDeleteActionFinishMessage(stationMessage);
        }
    }

    private static boolean validateAddStationName(String stationName, String stationMessage) {
        if (!StationRepository.validateNewName(stationName)) {
            throw new ExistentNameException(stationMessage);
        }
        if (!validateStationNameLength(stationName)) {
            throw new UnvalidNameLengthException();
        }
        return true;
    }

    private static boolean validateDeleteStationName(String stationName) {
        if (StationRepository.validateNewName(stationName)) {
            throw new NonExistentNameException();
        }
        if (!LineRepository.validateNewStationName(stationName)) {
            throw new RegisteredStationException();
        }
        return true;
    }

    private static boolean validateStationNameLength(String stationName) {
        if (stationName.length() >=  MINIMUM_LENGTH) {
            return true;
        }
        return false;
    }

    public static void printList(String stationMessage) {
        OutputView.printList(stationMessage, getStationNameList());
    }

    private static List<String> getStationNameList() {
        List<String> stationNames = new ArrayList<String>();
        List<Station> stations = StationRepository.stations();
        for (int i = 0; i < stations.size(); i++) {
            stationNames.add(stations.get(i).getName());
        }
        return stationNames;
    }
}
