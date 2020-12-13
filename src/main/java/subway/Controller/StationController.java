package subway.Controller;

import subway.Exception.ExceptionHandler;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    private static final String[] STATION_PATTERN = {"1", "2", "3", "B"};
    private static final String ADD = "1";
    private static final String DELETE = "2";
    private static final String TRAVERSE = "3";
    private static final String BACK = "B";

    public static void run() {
        OutputView.printStationView();
        String selection = InputView.getSelectionView();
        if (selection.equals(BACK)) {
            MainController.run();
        }
        ExceptionHandler.unselectable(selection, STATION_PATTERN);
        execute(selection);
    }

    private static void execute(String selection) {
        if (selection.equals(ADD)) {
            add();
        }
    }

    private static void add() {
        String name = InputView.getAddStation();
        ExceptionHandler.duplicatedStation(name);
        ExceptionHandler.stationNameShorterThanTwo(name);
        StationRepository.addStation(new Station(name));
        OutputView.printAddStationSuccess();
    }
}
