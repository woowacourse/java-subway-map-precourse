package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class StationManagement {
    private static final String REGISTER = "1";
    private static final String DELETE = "2";
    private static final String PRINT = "3";
    private static final String BACK = "B";

    private static String menu;

    public static void run() {
        do {
            OutputView.showStationManagementView();
            menu = InputView.getStationMenuSelection();
            runSelectedMenuFunction();
        } while(!menu.equals(BACK));
    }

    private static void runSelectedMenuFunction() {
        if (menu.equals(REGISTER)) {
            registerStation();
        }
        if (menu.equals(DELETE)) {
            deleteStation();
        }
        if (menu.equals(PRINT)) {
            printAllStation();
        }
    }

    private static void registerStation() {
        try {
            Station station = new Station(InputView.getStationNameToRegister());
            StationRepository.addStation(station);
            OutputView.printStationRegisterDone();
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
        }
    }

    private static void deleteStation() {
        try {
            String name = InputView.getStationNameToDelete();
            StationRepository.deleteStation(name);
            OutputView.printStationDeleteDone();
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
        }
    }

    private static void printAllStation() {
        try {
            List<String> stationNames = StationRepository.stations().stream()
                    .map(Station::getName)
                    .collect(Collectors.toList());
            OutputView.printStations(stationNames);
        } catch (RuntimeException e) {
            OutputView.showErrorMessage(e);
        }
    }
}
