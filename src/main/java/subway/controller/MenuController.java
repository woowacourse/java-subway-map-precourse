package subway.controller;

import subway.Menu;
import subway.SubMenu;
import subway.domain.exception.NonExistentMenuException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class MenuController {
    private static final String STATION_MANAGEMENT_SIGN = "1";
    private static final String LINE_MANAGEMENT_SIGN = "2";
    private static final String EDGE_MANAGEMENT_SIGN = "3";
    private static final String LINE_MAP_SIGN = "4";
    private static final String QUIT_SIGN = "Q";
    private static final int SUB_MENU_INDEX = 0;
    private static final int SUB_MENU_ACTION_INDEX = 1;
    private static final String NORMAL_SIGN = "NORMAL";
    private static final String ERROR_SIGN = "ERROR";
    public static ArrayList<String> selectedMenus = new ArrayList<String>();

    private static final Map<String, SubMenu> mainMenu = new LinkedHashMap<String, SubMenu>() {
        {
            put(STATION_MANAGEMENT_SIGN, Menu.stationMenu);
            put(LINE_MANAGEMENT_SIGN, Menu.lineMenu);
            put(EDGE_MANAGEMENT_SIGN, Menu.edgeMenu);
            put(LINE_MAP_SIGN, Menu.lineMap);
            put(QUIT_SIGN, Menu.quit);
        }
    };

    public static boolean runMenus(InputView inputView) {
        String runStatus = checkRunStatus(inputView);
        while (runStatus.equals(ERROR_SIGN)) {
            selectedMenus.remove(SUB_MENU_ACTION_INDEX);
            scanSubMenu(inputView, mainMenu.get(selectedMenus.get(SUB_MENU_INDEX)));
            runStatus = checkRunStatus(inputView);
        }
        if (runStatus.equals(QUIT_SIGN)) {
            return false;
        }
        return true;
    }

    private static String checkRunStatus(InputView inputView) {
        try {
            if (!Menu.runMenu(inputView, selectedMenus)) {
                return QUIT_SIGN;
            }
            return NORMAL_SIGN;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ERROR_SIGN;
        }
    }

    public static void scanMenu(InputView inputView) {
        String selectedMainMenu = scanMainMenu(inputView);
        if (Menu.isCategoricalMenu(mainMenu.get(selectedMainMenu))) {
            scanSubMenu(inputView, mainMenu.get(selectedMainMenu));
        }
    }

    public static String scanMainMenu(InputView inputView) {
        OutputView.printMainScreen();
        List<String> mainMenuSigns = new ArrayList<String> (mainMenu.keySet());
        String selectedMainMenu = scanValidMenu(inputView, mainMenuSigns);
        selectedMenus.add(selectedMainMenu);
        return selectedMainMenu;
    }

    private static void scanSubMenu(InputView inputView, SubMenu menu) {
        OutputView.printSubScreen(menu);
        List<String> subMenuSigns = new ArrayList<String> (menu.actionSign.keySet());
        String selectedSubMenu = scanValidMenu(inputView, subMenuSigns);
        selectedMenus.add(selectedSubMenu);
    }

    private static String scanValidMenu(InputView inputView, List<String> signs) {
        String menu = scanMenuCommand(inputView);
        while (!isValidMenu(menu, signs)) {
            menu = scanMenuCommand(inputView);
        }
        return menu;
    }

    private static String scanMenuCommand(InputView inputView) {
        OutputView.printMenuSelectScreen();
        return inputView.getInput();
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

    public static SubMenu getSubMenu(String menuSign) {
        return mainMenu.get(menuSign);
    }
}
