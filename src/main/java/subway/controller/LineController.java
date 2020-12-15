package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.LinePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LineController {
    private static final String ADD_LINE = "1";
    private static final String DELETE_LINE = "2";
    private static final String SELECT_LINE = "3";
    private static final String BACK = "B";
    private static final LinePage LINE_PAGE = new LinePage();


    public static void startLinePage(Scanner scanner) {
        LINE_PAGE.printLineManagementPage();
        forkPath(chooseItem(scanner), scanner);
    }

    public static void forkPath(String item, Scanner scanner) {
        if (ADD_LINE.equals(item)) {
            startInsertLine(scanner);
        }
        if (DELETE_LINE.equals(item)) {
            startDeleteLine(scanner);
        }
        if (SELECT_LINE.equals(item)) {
            startSelectLine(scanner);
        }
        if (BACK.equals(item)) {
            MainController.startMainPage(scanner);
        }
    }

    public static String chooseItem(Scanner scanner) {
        String item = input(scanner);
        if (!isValidItem(item)) {
            LINE_PAGE.printWrongItemError();
            startLinePage(scanner);
        }
        return item;
    }

    public static String input(Scanner scanner) {
        return scanner.next();
    }

    public static boolean isValidItem(String item) {
        return ADD_LINE.equals(item) || DELETE_LINE.equals(item) ||
                SELECT_LINE.equals(item) || BACK.equals(item);
    }

    public static void startInsertLine(Scanner scanner) {
        LINE_PAGE.printAddLinePage();
        String lineName = scanner.next();
        if (isValidName(lineName)) {
            List<Station> stations = new ArrayList<>();
            LINE_PAGE.printAddUpperTerminalPage();
            insertTerminal(stations, scanner);
            LINE_PAGE.printAddLowerTerminalPage();
            insertTerminal(stations, scanner);
            insertLine(lineName, stations, scanner);
        }
        startLinePage(scanner);
    }

    public static void insertLine(String lineName, List<Station> stations, Scanner scanner) {
        Line line = new Line(lineName, stations);
        LineRepository.addLine(line);
        LINE_PAGE.printCompleteAdd();
        MainController.startMainPage(scanner);
    }

    public static boolean isValidName(String name) {
        if (LineRepository.isLongName(name)) {
            if (!LineRepository.isExistName(name)) {
                return true;
            }
            LINE_PAGE.printDuplicateError();
            return false;
        }
        LINE_PAGE.printShortNameError();
        return false;
    }

    public static void insertTerminal(List<Station> stations, Scanner scanner) {
        String StationName = input(scanner);
        if (!StationRepository.isExistName(StationName)) {
            LINE_PAGE.printNullStationError();
            startLinePage(scanner);
            return;
        }
        Station upperStation = new Station(StationName);
        stations.add(upperStation);
    }

    public static void startDeleteLine(Scanner scanner) {
        LINE_PAGE.printDeleteLinePage();
        deleteLine(scanner);
    }

    public static void deleteLine(Scanner scanner) {
        String LineName = input(scanner);
        if (LineRepository.isExistName(LineName)) {
            if (LineRepository.deleteLineByName(LineName)) {
                LINE_PAGE.printCompleteDelete();
                MainController.startMainPage(scanner);
                return;
            }
            LINE_PAGE.printFailToDeleteError();
            startLinePage(scanner);
            return;
        }
        LINE_PAGE.printNullLineError();
        startLinePage(scanner);
    }

    public static void startSelectLine(Scanner scanner) {
        LINE_PAGE.printSelectLinesPage(LineRepository.lines());
        MainController.startMainPage(scanner);
    }
}
