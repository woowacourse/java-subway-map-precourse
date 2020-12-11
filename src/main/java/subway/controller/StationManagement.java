package subway.controller;

import subway.MenuType.FunctionType;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.OutputView;
import subway.view.managementView.StationView;

import java.util.List;
import java.util.stream.Collectors;

public class StationManagement {

    private static StationView stationView = StationView.getInstance();
    private static FunctionType menu;

    public static void run() {
        do {
            stationView.showMenu();
            menu = stationView.getFunctionSelection();
            runSelectedMenuFunction();
        } while(!menu.equals(FunctionType.ESCAPE));
    }

    private static void runSelectedMenuFunction() {
        if (menu.equals(FunctionType.CREATE)) {
            registerStation();
        }
        if (menu.equals(FunctionType.DELETE)) {
            deleteStation();
        }
        if (menu.equals(FunctionType.READ)) {
            printAllStation();
        }
    }

    private static void registerStation() {
        try {
            Station station = new Station(stationView.getNameToCreate());
            StationRepository.addStation(station);
            stationView.printRegisterDone();
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
        }
    }

    private static void deleteStation() {
        try {
            String name = stationView.getNameToDelete();
            StationRepository.deleteStation(name);
            stationView.printDeleteDone();
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
        }
    }

    private static void printAllStation() {
        try {
            List<String> stationNames = StationRepository.stations().stream()
                    .map(Station::getName)
                    .collect(Collectors.toList());
            stationView.printAll(stationNames);
        } catch (RuntimeException e) {
            OutputView.showErrorMessage(e);
        }
    }
}
