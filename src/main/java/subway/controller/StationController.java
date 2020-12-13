package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.StationOutputView;

public class StationController {
    public static void addStation() {
        try {
            tryToAddStation();
            backToMainMenu();
        } catch (Exception exception) {
            catchError(exception);
        }
    }

    private static void tryToAddStation() {
        StationOutputView.requestStationNameToAdd();
        StationRepository.addStation(new Station(InputView.getInput()));
        StationOutputView.informStationAdded();
    }

    public static void deleteStation() {
        try {
            tryToDeleteStation();
            backToMainMenu();
        } catch (Exception exception) {
            catchError(exception);
        }
    }
    
    private static void tryToDeleteStation() {
        StationOutputView.requestStationNameToDelete();
        StationRepository.deleteStation(InputView.getInput());
        StationOutputView.informStationDeleted();
    }

    public static void showStations() { 
        StationOutputView.printStations();
        backToMainMenu();
    }

    public static void backToMainMenu() {
        MenuController.callMainMenu();
    }

    private static void catchError(Exception exception) {
        OutputView.printError(exception);
        MenuController.callStationMenu();
    }
}
