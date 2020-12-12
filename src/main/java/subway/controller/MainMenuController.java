package subway.controller;

import subway.exception.ExitSystemException;
import subway.view.InputView;
import subway.view.OutputView;

public class MainMenuController {

    public static final String TITLE = "메인 화면";

    public static final String MANAGE_STATION = "1";
    public static final String MANAGE_LINE = "2";
    public static final String MANAGE_SECTION = "3";
    public static final String PRINT_SUBWAY_MAP = "4";
    public static final String EXIT_SYSTEM = "Q";

    private MainMenuController() {
    }

    public static void main() {
        printMenu();
        while (true) {
            try {
                route(InputView.getInput());
            } catch (ExitSystemException e) {
                OutputView.printError(e);
                return;
            }
        }
    }

    private static void printSubwayMap() {
        // 지하철 노선도 출력
    }

    private static void exitSystem() {
        throw new ExitSystemException();
    }

    private static void printMenu() {
        OutputView.printInfo(TITLE);
    }

    private static void route(String input) {
        if (MANAGE_STATION.equals(input)) {
            StationMenuController.main();
        }
        if (MANAGE_LINE.equals(input)) {
            StationMenuController.main();
        }
        if (MANAGE_SECTION.equals(input)) {
            StationMenuController.main();
        }
        if (PRINT_SUBWAY_MAP.equals(input)) {
            StationMenuController.main();
        }
        if (EXIT_SYSTEM.equals(input)) {
            StationMenuController.main();
        }
    }

    private static void routeToStationMenu() {

    }

}
