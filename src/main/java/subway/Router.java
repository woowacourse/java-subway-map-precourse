package subway;

import java.util.List;
import java.util.Scanner;
import subway.controller.StationController;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class Router {
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String BACK = "B";
    private static final String QUIT = "Q";

    private static OutputView monitor = System.out::println;

    private InputView inputView;
    private StationController stationController;

    public Router(Scanner scanner) {
        this.inputView = new InputView(monitor, scanner);
        this.stationController = new StationController(monitor);
    }

    public void run() {
        String command;
        do {
            command = inputView.getScreenCommand("MAIN_SCREEN", OutputView.MAIN_SCREEN);
        } while (routeMainScreen(command));
    }

    private boolean routeMainScreen(String command) {
        if (command.equals(QUIT)) {
            return false;
        }
        if (command.equals(ONE)) {
            enterStationManagementScreen();
            return true;
        }
        if (command.equals(TWO)) {
            enterLineManagementScreen();
            return true;
        }
        return false;
    }

    private void enterStationManagementScreen() {
        String command = inputView.getScreenCommand("STATION_MANAGEMENT_SCREEN"
            , OutputView.STATION_MANAGEMENT_SCREEN);
        routeStationManagementScreen(command);
    }

    private void enterLineManagementScreen() {
        String command = inputView.getScreenCommand("LINE_MANAGEMENT_SCREEN"
            , OutputView.LINE_MANAGEMENT_SCREEN);
        routeLineManagementScreen(command);
    }

    private void routeStationManagementScreen(String command) {
        if (command.equals(ONE)) {
            String stationName = inputView.getStationName(OutputView.ORDER_TO_REGISTER_STATION);
            stationController.registerStation(stationName);
        }
        if (command.equals(TWO)) {
            String stationName = inputView.getStationName(OutputView.ORDER_TO_DELETE_STATION);
            stationController.deleteStation(stationName);
        }
        if (command.equals(THREE)) {
            List<Station> stations = stationController.searchStation();
            monitor.print(OutputView.STATION_LIST);
            OutputView.printStationList(stations);
        }
    }

    private void routeLineManagementScreen(String command) {
        if (command.equals(ONE)) {
        }
        if (command.equals(TWO)) {
        }
        if (command.equals(THREE)) {
        }
    }
}