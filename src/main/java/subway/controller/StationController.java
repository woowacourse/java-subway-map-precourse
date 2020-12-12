package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

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
        OutputView.requestStationNameToAdd();
        StationRepository.addStation(new Station(InputView.getInput()));
        OutputView.informStationAdded();
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
        OutputView.requestStationNameToDelete();
        StationRepository.deleteStation(InputView.getInput());
        OutputView.informStationDeleted();
    }

    public static void showStations() { 
        OutputView.printStations();
        backToMainMenu();
    }

    public static void backToMainMenu() {
        SubwayMapController.callMainMenu();
    }

    private static void catchError(Exception exception) {
        OutputView.printError(exception);
        SubwayMapController.callStationMenu();
    }
}
