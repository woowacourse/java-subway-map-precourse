package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {
    public static void addStation() {
        try {
            tryToAddStation();
            SubwayMapController.callMainMenu();
        } catch (Exception exception) {
            OutputView.printError(exception);
            SubwayMapController.callStationMenu();
        }
    }

    private static void tryToAddStation() {
        OutputView.requestStationNameToAdd();
        StationRepository.addStation(new Station(InputView.getInput()));
        OutputView.informStationAdded();
    }
}
