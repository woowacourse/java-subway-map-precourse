package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.StationPage;
import utils.ErrorUtils;
import utils.InfoUtils;

import java.util.Scanner;


public class StationController {
    private static final String ADD_STATION = "1";
    private static final String DELETE_STATION = "2";
    private static final String SELECT_STATION = "3";
    private static final String BACK = "B";
    private static StationPage stationPage = new StationPage();

    public static void startStationPage(Scanner scanner) {
        stationPage.printStationManagementPage();
        forkPath(chooseItem(scanner), scanner);
    }

    public static void forkPath(String item, Scanner scanner) {
        if (ADD_STATION.equals(item)) {
            startInsertStation(scanner);
        }
        if (DELETE_STATION.equals(item)) {
            startDeleteStation(scanner);
        }
        if (SELECT_STATION.equals(item)) {
            startSelectStation(scanner);
        }
        if (BACK.equals(item)) {
            MainController.startMainPage(scanner);
        }
    }

    public static String chooseItem(Scanner scanner) {
        String item = input(scanner);
        if (!isValidItem(item)) {
            stationPage.printWrongItemError();
            startStationPage(scanner);
        }
        return item;
    }

    public static String input(Scanner scanner) {
        return scanner.next();
    }

    public static boolean isValidItem(String item) {
        if (ADD_STATION.equals(item) || DELETE_STATION.equals(item) ||
                SELECT_STATION.equals(item) || BACK.equals(item)) {
            return true;
        }
        return false;
    }

    public static void startInsertStation(Scanner scanner) {
        stationPage.printAddStationPage();
        insertStation(scanner);
    }

    public static void insertStation(Scanner scanner) {
        String stationName = input(scanner);
        if (isValidName(stationName)) {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
            stationPage.printCompleteAdd();
            MainController.startMainPage(scanner);
            return;
        }
        startStationPage(scanner);
    }

    public static boolean isValidName(String name) {
        if (StationRepository.isLongName(name)) {
            if (!StationRepository.isExistName(name)) {
                return true;
            }
            stationPage.printDuplicateError();
            return false;
        }
        stationPage.printShortNameError();
        return false;
    }

    public static void startDeleteStation(Scanner scanner) {
        stationPage.printDeleteStationPage();
        deleteStation(scanner);
    }

    public static void deleteStation(Scanner scanner) {
        String stationName = input(scanner);
        if (StationRepository.isExistName(stationName)) {
            StationRepository.deleteStation(stationName);
            stationPage.printCompleteDelete();
            MainController.startMainPage(scanner);
            return;
        }
        stationPage.printNullLineError();
        startStationPage(scanner);
    }

    public static void startSelectStation(Scanner scanner) {
        stationPage.printSelectStationsPage(StationRepository.stations());
        MainController.startMainPage(scanner);
    }

}
