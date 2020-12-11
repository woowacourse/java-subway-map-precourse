package subway;

import java.util.List;
import java.util.Scanner;
import subway.controller.StationController;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.LogMessage;

public class Router {
    private static final String QUIT = "Q";
    private static final String STATION = "1";
    private static final String REGISTER = "1";
    private static final String DELETE = "2";
    private static final String SEARCH = "3";
    private static final String BACK = "B";

    private InputView inputView;

    public Router(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void run() {
        String command;
        do {
            command = inputView.getMainScreenCommand();
        } while (routeMainScreen(command));
    }

    private boolean routeMainScreen(String command) {
        if (command.equals(QUIT)) {
            LogMessage.printEndMessage();
            return false;
        }
        if (command.equals(STATION)) {
            enterStationManagementScreen();
            return true;
        }
        return false;
    }

    private void enterStationManagementScreen() {
        String command = inputView.getStationManagementScreenCommand();
        routeStationManagementScreen(command);
    }

    private void routeStationManagementScreen(String command) {
        if (command.equals(REGISTER)) {
            String stationName = inputView.getStationName();
            StationController.registerStation(stationName);
        }
        if (command.equals(DELETE)) {

        }
        if (command.equals(SEARCH)) {
            StationController.searchStation();
        }
        if (command.equals(BACK)) {
            LogMessage.printBackToMainScreen();
        }
    }

}