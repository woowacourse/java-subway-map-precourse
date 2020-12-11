package subway.controller;

import subway.domain.station.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController extends Controller {

    private static final int ADD_FUNCTION = 1;
    private static final int DELETE_FUNCTION = 2;
    private static final int VIEW_FUNCTION = 3;

    public StationController(InputView inputView) {
        super(inputView);
    }

    @Override
    public void run() {
        try {
            String functionDecision = inputView.inputFunction(Function.STATION_MENU);
            if(Function.isExitDecision(functionDecision, Function.STATION_MENU)) {
                return;
            }
            Function.validate(functionDecision, Function.STATION_MENU);
            goTo(Integer.parseInt(functionDecision));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            run();
        }
    }

    private void goTo(int function) {
        if (function == ADD_FUNCTION) {
            addStation();
        }
        if (function == DELETE_FUNCTION) {
            deleteStation();
        }
        if (function == VIEW_FUNCTION) {
            viewStations();
        }
    }

    private void addStation() {
        try {
            String rawStationName = inputView.inputName(InputView.CHOOSE_ADD_STATION);
            Station.validateName(rawStationName);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            addStation();
        }
    }

    private void deleteStation() {
        try {
            String rawStationName = inputView.inputName(InputView.CHOOSE_DELETE_STATION);
            Station.validateName(rawStationName);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            deleteStation();
        }
    }

    private void viewStations() {

    }
}
