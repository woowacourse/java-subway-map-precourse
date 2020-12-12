package subway;

import java.util.Scanner;
import subway.controller.StationController;
import subway.view.InputView;
import subway.view.LogMessage;
import subway.view.OutputView;

public class Router {
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String BACK = "B";
    private static final String QUIT = "Q";

    private InputView inputView;

    public Router(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void run() {
        String command;
        do {
            OutputView.printMainScreen();
            command = inputView.getScreenCommand("MAIN_SCREEN");
        } while (routeMainScreen(command));
    }

    private boolean routeMainScreen(String command) {
        if (command.equals(QUIT)) {
            LogMessage.printEndMessage();
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
        OutputView.printStationManagementScreen();
        String command = inputView.getScreenCommand("STATION_MANAGEMENT_SCREEN");
        routeStationManagementScreen(command);
    }

    private void enterLineManagementScreen() {
        OutputView.printLineManagementScreen();
        String command = inputView.getScreenCommand("LINE_MANAGEMENT_SCREEN");
    }

    private void routeStationManagementScreen(String command) {
        if (command.equals(ONE)) {
            OutputView.printOrderToRegisterStation();
            String stationName = inputView.getStationName();
            StationController.registerStation(stationName);
        }
        if (command.equals(TWO)) {
            OutputView.printOrderToDeleteStation();
            String stationName = inputView.getStationName();
            StationController.deleteStation(stationName);
        }
        if (command.equals(THREE)) {
            StationController.searchStation();
        }
        if (command.equals(BACK)) {
            LogMessage.printBackToMainScreen();
        }
    }

}