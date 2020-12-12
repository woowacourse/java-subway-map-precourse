package subway.controller;

import subway.domain.exception.NonExistentMenuException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    private static final List<String> MAIN_MENU_SIGN = Arrays.asList(new String[] {"1","2","3","4","Q"});
    private static final List<String> STATION_MANAGEMENT_MENU_SIGN = Arrays.asList(new String[] {"1","2","3","B"});
    private static final List<String> LINE_MANAGEMENT_MENU_SIGN = Arrays.asList(new String[] {"1","2","3","B"});
    private static final List<String> EDGE_MANAGEMENT_MENU_SIGN = Arrays.asList(new String[] {"1","2","B"});

    public static String scanMainMenu(Scanner scanner) {
        OutputView.printMainScreen();
        return scanValidMenu(scanner, MAIN_MENU_SIGN);
    }

    public static String scanStationManagementMenu(Scanner scanner) {
        OutputView.printStationManagementScreen();
        return scanValidMenu(scanner, STATION_MANAGEMENT_MENU_SIGN);
    }

    public static String scanLineManagementMenu(Scanner scanner) {
        OutputView.printLineManagementScreen();
        return scanValidMenu(scanner, LINE_MANAGEMENT_MENU_SIGN);
    }

    public static String scanEdgeManagementMenu(Scanner scanner) {
        OutputView.printEdgeManagementScreen();
        return scanValidMenu(scanner, EDGE_MANAGEMENT_MENU_SIGN);
    }

    private static String scanValidMenu(Scanner scanner, List<String> signs) {
        String menu = scanMenu(scanner);
        while (!isValidMenu(menu,signs)) {
            menu = scanMenu(scanner);
        }
        return menu;
    }

    private static String scanMenu(Scanner scanner) {
        OutputView.printMenuSelectScreen();
        return InputView.getInput(scanner);
    }

    public static boolean isValidMenu(String menu, List<String> signs) {
        try{
            validateMenu(menu, signs);
            return true;
        } catch (NonExistentMenuException menuError) {
            System.out.println(menuError.getMessage());
            return false;
        }
    }

    public static boolean validateMenu(String menu, List<String> signs) {
        if (!signs.contains(menu)) {
            throw new NonExistentMenuException();
        }
        return true;
    }
}
