package subway;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import subway.controller.LineController;
import subway.controller.StationController;
import subway.domain.Line;
import subway.domain.Station;
import subway.util.MainScreen;
import subway.view.InputView;
import subway.view.OutputView;

public class Router {
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String BACK = "B";
    private static final String QUIT = "Q";

    private static InputView inputView;

    public Router(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void run() {
        String command;
        do {
            command = inputView.getScreenCommand("MAIN_SCREEN", OutputView.MAIN_SCREEN);
        } while (routeMainScreen(command));
    }

    private boolean routeMainScreen(String command) {
        return MainScreen.run(command);
    }

    public static boolean enterStationManagementScreen() {
        String command = inputView.getScreenCommand("STATION_MANAGEMENT_SCREEN"
            , OutputView.STATION_MANAGEMENT_SCREEN);

        if (routeStationManagementScreen(command)) {
            return enterStationManagementScreen();
        }
        return true;
    }

    public static boolean enterLineManagementScreen() {
        String command = inputView.getScreenCommand("LINE_MANAGEMENT_SCREEN"
            , OutputView.LINE_MANAGEMENT_SCREEN);

        if (routeLineManagementScreen(command)) {
            return enterLineManagementScreen();
        }
        return true;
    }

    public static boolean enterSectionManagementScreen() {
        String command = inputView.getScreenCommand("SECTION_MANAGEMENT_SCREEN"
            , OutputView.SECTION_MANAGEMENT_SCREEN);

        if (routeSectionManagementScreen(command)) {
            return enterSectionManagementScreen();
        }
        return true;
    }

    public static boolean routeStationManagementScreen(String command) {
        if (command.equals(BACK)) {
            return false;
        }
        if (command.equals(ONE)) {
            String stationName = inputView.getName(OutputView.ORDER_TO_REGISTER_STATION);
            return StationController.registerStation(stationName);
        }
        if (command.equals(TWO)) {
            String stationName = inputView.getName(OutputView.ORDER_TO_DELETE_STATION);
            return StationController.deleteStation(stationName);
        }
        if (command.equals(THREE)) {
            List<Station> stations = StationController.searchStation();
            OutputView.print(OutputView.STATION_LIST);
            OutputView.printList(stations);
        }
        return false;
    }

    public static boolean routeLineManagementScreen(String command) {
        if (command.equals(BACK)) {
            return false;
        }
        if (command.equals(ONE)) {
            String lineName = inputView.getName(OutputView.ORDER_TO_REGISTER_LINE);
            String upTrainLastStationName = inputView
                .getName(OutputView.ORDER_TO_REGISTER_UP_TRAIN_LAST_STATION);
            String downTrainLastStationName = inputView
                .getName(OutputView.ORDER_TO_REGISTER_DOWN_TRAIN_LAST_STATION);
            return LineController
                .registerLine(lineName, upTrainLastStationName, downTrainLastStationName);
        }
        if (command.equals(TWO)) {
            String lineName = inputView.getName(OutputView.ORDER_TO_DELETE_LINE);
            return LineController.deleteLine(lineName);
        }
        if (command.equals(THREE)) {
            List<Line> lines = new ArrayList<>(LineController.searchLine().keySet());
            OutputView.print(OutputView.LINE_LIST);
            OutputView.printList(lines);
        }
        return false;
    }

    public static boolean routeSectionManagementScreen(String command) {
        if (command.equals(BACK)) {
            return false;
        }
        if (command.equals(ONE)) {
            String lineName = inputView.getName(OutputView.ORDER_TO_ENTER_LINE);
            String stationName = inputView.getName(OutputView.ORDER_TO_ENTER_STATION);
            int sequence = inputView.getSequence(OutputView.ORDER_TO_ENTER_SEQUENCE);
            return LineController.registerSection(lineName, stationName, sequence);
        }
        if (command.equals(TWO)) {
            String lineName = inputView.getName(OutputView.ORDER_TO_ENTER_LINE_TO_DELETE);
            String stationName = inputView.getName(OutputView.ORDER_TO_ENTER_STATION_TO_DELETE);
            return LineController.deleteSection(lineName, stationName);
        }
        return false;
    }
}