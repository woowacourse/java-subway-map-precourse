package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.OutputView;
import subway.view.managementView.StationView;

import java.util.List;
import java.util.stream.Collectors;

public class StationManagement {
    private static final String CREATE = "1";
    private static final String DELETE = "2";
    private static final String READ = "3";
    private static final String ESCAPE = "B";

    private static StationView stationView = StationView.getInstance();
    private static String menu;

    public static void run() {
        do {
            stationView.showMenu();
            menu = stationView.getFunctionSelection();
            runSelectedMenuFunction();
        } while(!menu.equals(ESCAPE));
    }

    private static void runSelectedMenuFunction() {
        if (menu.equals(CREATE)) {
            registerStation();
        }
        if (menu.equals(DELETE)) {
            deleteStation();
        }
        if (menu.equals(READ)) {
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
