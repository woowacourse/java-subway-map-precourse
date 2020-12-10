package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationManagement {
    private static final String REGISTER = "1";
    private static final String DELETE = "2";
    private static final String DISPLAY = "3";
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
    }

    private static void registerStation() {
        try {
            Station station = new Station(InputView.getStationNameToRegister());
            StationRepository.addStation(station);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
        }
    }

    private static void deleteStation() {
        try {
            String name = InputView.getStationNameToDelete();
            StationRepository.deleteStation(name);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
        }
    }
}
