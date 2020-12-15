package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.RouteMapPage;

import java.util.Scanner;

public class RouteMapController {
    private static final String ADD_ROUTE = "1";
    private static final String DELETE_ROUTE = "2";
    private static final String BACK = "B";
    private static final RouteMapPage ROUTE_MAP_PAGE = new RouteMapPage();


    public static void startRouteMapPage(Scanner scanner) {
        ROUTE_MAP_PAGE.printRouteManagementPage();
        forkPath(chooseItem(scanner), scanner);
    }

    public static void forkPath(String item, Scanner scanner) {
        if (ADD_ROUTE.equals(item)) {
            startInsertRouteMap(scanner);
        }
        if (DELETE_ROUTE.equals(item)) {
            startDeleteRouteMap(scanner);
        }
        if (BACK.equals(item)) {
            MainController.startMainPage(scanner);
        }
    }

    public static void startInsertRouteMap(Scanner scanner) {
        ROUTE_MAP_PAGE.printChooseLinePage();
        String lineName = input(scanner);
        if (isExistLine(lineName, scanner)) {
            Line line = LineRepository.selectOneLineByName(lineName);
            ROUTE_MAP_PAGE.printChooseStationPage();
            String stationName = input(scanner);
            if (isValidStation(line, stationName, scanner)) {
                ROUTE_MAP_PAGE.printChooseIndexPage();
                insertRouteMap(line, stationName, scanner);
            }
        }
    }

    public static void insertRouteMap(Line line, String stationName, Scanner scanner) {
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (isLowerNumThanLineSize(index, line, scanner)) {
            LineRepository.addStationByIndex(index, line, stationName);
            ROUTE_MAP_PAGE.printCompleteAdd();
            MainController.startMainPage(scanner);
        }
    }

    public static void startDeleteRouteMap(Scanner scanner) {
        ROUTE_MAP_PAGE.printChooseDeleteLinePage();
        String lineName = input(scanner);
        if (isExistLine(lineName, scanner)) {
            Line line = LineRepository.selectOneLineByName(lineName);
            ROUTE_MAP_PAGE.printChooseDeleteStationPage();
            String stationName = input(scanner);
            if (LineRepository.isDuplicateStationInLine(line, stationName)) {
                deleteRoute(line, stationName, scanner);
                return;
            }
            ROUTE_MAP_PAGE.printNullStationError();
            startRouteMapPage(scanner);
        }
    }

    public static void deleteRoute(Line line, String stationName, Scanner scanner) {
        final int MINIMUM_STATION_NUM = 2;
        if (LineRepository.countStationNumInLine(line) > MINIMUM_STATION_NUM) {
            LineRepository.deleteStationByName(line, stationName);
            ROUTE_MAP_PAGE.printCompleteDelete();
            MainController.startMainPage(scanner);
        }
        ROUTE_MAP_PAGE.printDeleteError();
        startRouteMapPage(scanner);
    }

    public static String chooseItem(Scanner scanner) {
        String item = input(scanner);
        if (!isValidItem(item)) {
            ROUTE_MAP_PAGE.printWrongItemError();
            startRouteMapPage(scanner);
        }
        return item;
    }

    public static String input(Scanner scanner) {
        return scanner.next();
    }

    public static boolean isValidItem(String item) {
        return ADD_ROUTE.equals(item) || DELETE_ROUTE.equals(item) || BACK.equals(item);
    }

    public static boolean isExistLine(String lineName, Scanner scanner) {
        if (!LineRepository.isExistName(lineName)) {
            ROUTE_MAP_PAGE.printNullLineError();
            startRouteMapPage(scanner);
            return false;
        }
        return true;
    }

    public static boolean isValidStation(Line line, String stationName, Scanner scanner) {
        if (StationRepository.isExistName(stationName)) {
            if (!LineRepository.isDuplicateStationInLine(line, stationName)) {
                return true;
            }
            ROUTE_MAP_PAGE.printDuplicateStationInLineError();
            startRouteMapPage(scanner);
            return false;
        }
        ROUTE_MAP_PAGE.printNullStationError();
        startRouteMapPage(scanner);
        return false;
    }

    public static boolean isLowerNumThanLineSize(int index, Line line, Scanner scanner) {
        if (line.getStationNumber() >= index) {
            return true;
        }
        ROUTE_MAP_PAGE.printWrongIndexError();
        startRouteMapPage(scanner);
        return false;
    }
}
