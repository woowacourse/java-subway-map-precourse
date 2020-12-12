package subway.controller;

import subway.Menu;
import subway.SubMenu;
import subway.domain.exception.NonExistentMenuException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;

public class MenuController {
    private static final String STATION_MANAGEMENT_SIGN = "1";
    private static final String LINE_MANAGEMENT_SIGN = "2";
    private static final String EDGE_MANAGEMENT_SIGN = "3";
    private static final String LINE_MAP_SIGN = "4";
    private static final String QUIT_SIGN = "Q";

    private static final Map<String, SubMenu> mainMenu = new LinkedHashMap<String, SubMenu>() {
        {
            put(STATION_MANAGEMENT_SIGN, Menu.stationMenu);
            put(LINE_MANAGEMENT_SIGN, Menu.lineMenu);
            put(EDGE_MANAGEMENT_SIGN, Menu.edgeMenu);
            put(LINE_MAP_SIGN, Menu.lineMap);
            put(QUIT_SIGN, Menu.quit);
        }
    };

    public static SubMenu scanMenu(Scanner scanner) {
        SubMenu selectedMainMenu = scanMainMenu(scanner);
        if (Menu.isCategoricalMenu(selectedMainMenu)) {
            return scanSubMenu(scanner, selectedMainMenu);
        }
        return selectedMainMenu;
    }

    public static SubMenu scanMainMenu(Scanner scanner) {
        OutputView.printMainScreen();
        List<String> mainMenuSigns = new ArrayList<String> (mainMenu.keySet());
        return scanValidMenu(scanner, mainMenuSigns);
    }

    private static SubMenu scanSubMenu(Scanner scanner, SubMenu menu) {
        OutputView.printSubScreen(menu);
        List<String> subMenuSigns = new ArrayList<String> (menu.actionSign.keySet());
        return scanValidMenu(scanner, subMenuSigns);
    }

    private static SubMenu scanValidMenu(Scanner scanner, List<String> signs) {
        String menu = scanMenuCommand(scanner);
        while (!isValidMenu(menu, signs)) {
            menu = scanMenuCommand(scanner);
        }
        return mainMenu.get(menu);
    }

    private static String scanMenuCommand(Scanner scanner) {
        OutputView.printMenuSelectScreen();
        return InputView.getInput(scanner);
    }

    public static boolean isValidMenu(String menu, List<String> signs) {
        try {
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
