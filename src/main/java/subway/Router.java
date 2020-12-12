package subway;

import java.util.List;
import java.util.Scanner;
import subway.controller.LineController;
import subway.controller.StationController;
import subway.domain.Line;
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
    private LineController lineController;

    public Router(Scanner scanner) {
        this.inputView = new InputView(monitor, scanner);
        this.stationController = new StationController(monitor);
        this.lineController = new LineController(monitor);
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
            return enterStationManagementScreen();
        }
        if (command.equals(TWO)) {
            return enterLineManagementScreen();
        }
        if (command.equals(THREE)){
        }
        return false;
    }

    private boolean enterStationManagementScreen() {
        String command= inputView.getScreenCommand("STATION_MANAGEMENT_SCREEN"
            , OutputView.STATION_MANAGEMENT_SCREEN);

        if (routeStationManagementScreen(command)){
            return enterStationManagementScreen();
        }
        return true;
    }

    private boolean enterLineManagementScreen() {
        String command = inputView.getScreenCommand("LINE_MANAGEMENT_SCREEN"
            , OutputView.LINE_MANAGEMENT_SCREEN);

        if(routeLineManagementScreen(command)){
            return enterLineManagementScreen();
        }
        return true;
    }

    private boolean routeStationManagementScreen(String command) {
        if (command.equals(BACK)) {
            return false;
        }
        if (command.equals(ONE)) {
            String stationName = inputView.getName(OutputView.ORDER_TO_REGISTER_STATION);
            return stationController.registerStation(stationName);
        }
        if (command.equals(TWO)) {
            String stationName = inputView.getName(OutputView.ORDER_TO_DELETE_STATION);
            return stationController.deleteStation(stationName);
        }
        if (command.equals(THREE)) {
            List<Station> stations = stationController.searchStation();
            monitor.print(OutputView.STATION_LIST);
            OutputView.printList(stations);
        }
        return false;
    }

    private boolean routeLineManagementScreen(String command) {
        if (command.equals(BACK)) {
            return false;
        }
        if (command.equals(ONE)) {
            String lineName = inputView.getName(OutputView.ORDER_TO_REGISTER_LINE);
            String upTrainLastStationName = inputView.getName(OutputView.ORDER_TO_REGISTER_UP_TRAIN_LAST_STATION);
            String downTrainLastStationName = inputView.getName(OutputView.ORDER_TO_REGISTER_DOWN_TRAIN_LAST_STATION);
            return lineController.registerLine(lineName,upTrainLastStationName,downTrainLastStationName);
        }
        if (command.equals(TWO)) {
            String lineName = inputView.getName(OutputView.ORDER_TO_DELETE_LINE);
            return lineController.deleteLine(lineName);
        }
        if (command.equals(THREE)) {
            List<Line> lines = lineController.searchLine();
            monitor.print(OutputView.LINE_LIST);
            OutputView.printList(lines);
        }
        return false;
    }
}