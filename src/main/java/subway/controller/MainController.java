package subway.controller;

import subway.InitialSetting;
import subway.domain.LineRepository;
import subway.view.MainPage;

import java.util.Scanner;

public class MainController {
    private static final String STATION_MANAGEMENT = "1";
    private static final String LINE_MANAGEMENT = "2";
    private static final String ROUTE_MANAGEMENT = "3";
    private static final String ROUTE_MAP = "4";
    private static final String QUIT = "Q";
    private static final MainPage MAIN_PAGE = new MainPage();

    public MainController(Scanner scanner) {
        InitialSetting initialSetting = new InitialSetting();
        startMainPage(scanner);
    }

    public static void startMainPage(Scanner scanner) {
        MAIN_PAGE.printMainPage();
        forkPath(chooseItem(scanner), scanner);
    }

    public static void forkPath(String item, Scanner scanner) {
        if (STATION_MANAGEMENT.equals(item)) {
            StationController.startStationPage(scanner);
        }
        if (LINE_MANAGEMENT.equals(item)) {
            LineController.startLinePage(scanner);
        }
        if (ROUTE_MANAGEMENT.equals(item)) {
            RouteMapController.startRouteMapPage(scanner);
        }
        if (ROUTE_MAP.equals(item)) {
            selectRouteMap(scanner);
        }
    }

    public static void selectRouteMap(Scanner scanner) {
        MAIN_PAGE.printRouteMap(LineRepository.lines());
        startMainPage(scanner);
    }

    public static String chooseItem(Scanner scanner) {
        String item = input(scanner);
        if (!isValidItem(item)) {
            MAIN_PAGE.printWrongItemError();
            startMainPage(scanner);
        }
        return item;
    }

    public static String input(Scanner scanner) {
        return scanner.next();
    }

    public static boolean isValidItem(String input) {
        return STATION_MANAGEMENT.equals(input) || LINE_MANAGEMENT.equals(input) ||
                ROUTE_MANAGEMENT.equals(input) || ROUTE_MAP.equals(input) || QUIT.equalsIgnoreCase(input);
    }
}
