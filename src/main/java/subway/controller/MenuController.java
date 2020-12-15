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
    private static final Map<String, SubMenu> mainMenu = new LinkedHashMap<String, SubMenu>() {
        {
            put(STATION_MANAGEMENT_SIGN, Menu.stationMenu);
            put(LINE_MANAGEMENT_SIGN, Menu.lineMenu);
            put(EDGE_MANAGEMENT_SIGN, Menu.edgeMenu);
            put(LINE_MAP_SIGN, Menu.lineMap);
            put(QUIT_SIGN, Menu.quit);
        }
    };

    public ArrayList<String> selectedMenus;
    private final InputView inputView;

    public MenuController(InputView inputView) {
        this.inputView = inputView;
        this.selectedMenus = new ArrayList<String>();
    }

    public boolean runMenus() {
        String runStatus = runMenu();
        while (runStatus.equals(ERROR_SIGN)) {
            selectedMenus.remove(SUB_MENU_ACTION_INDEX);
            scanSubMenu(getSubMenu(selectedMenus.get(SUB_MENU_INDEX)));
            runStatus = runMenu();
        }
        if (runStatus.equals(QUIT_SIGN)) {
            return false;
        }
        return true;
    }

    private String runMenu() {
        try {
            if (isQuit()) {
                return QUIT_SIGN;
            }
            runAction(getSubMenu(selectedMenus.get(SUB_MENU_ACTION_INDEX)));
            return NORMAL_SIGN;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ERROR_SIGN;
        }
    }

    private boolean isQuit() {
        SubMenu menu = getSubMenu(selectedMenus.get(SUB_MENU_INDEX));
        if (menu == Menu.quit) {
            return true;
        }
        return false;
    }

    private void runAction(SubMenu menu) {
        boolean runActionStatus = true;
        if (menu == Menu.stationMenu) {
            runActionStatus = Menu.runStationMenu(inputView, selectedMenus.get(SUB_MENU_ACTION_INDEX));
        }
        if (menu == Menu.lineMenu) {
            runActionStatus = Menu.runLineMenu(inputView, selectedMenus.get(SUB_MENU_ACTION_INDEX));
        }
        if (menu == Menu.edgeMenu) {
            runActionStatus = Menu.runEdgeMenu(inputView, selectedMenus.get(SUB_MENU_ACTION_INDEX));
        }
        if (menu == Menu.lineMap) {
            Menu.runLineMapMenu();
        }
        //돌아가기를 선택한 경우
        if (!runActionStatus) {
            selectedMenus.clear();
        }
    }

    public void scanMenu() {
        String selectedMainMenu = scanMainMenu();
        if (Menu.isCategoricalMenu(mainMenu.get(selectedMainMenu))) {
            scanSubMenu(mainMenu.get(selectedMainMenu));
        }
    }

    private String scanMainMenu() {
        OutputView.printMainScreen();
        List<String> mainMenuSigns = new ArrayList<String> (mainMenu.keySet());
        String selectedMainMenu = scanValidMenu(mainMenuSigns);
        selectedMenus.add(selectedMainMenu);
        return selectedMainMenu;
    }

    private void scanSubMenu(SubMenu menu) {
        OutputView.printSubScreen(menu);
        List<String> subMenuSigns = new ArrayList<String> (menu.actionSign.keySet());
        String selectedSubMenu = scanValidMenu(subMenuSigns);
        selectedMenus.add(selectedSubMenu);
    }

    private String scanValidMenu(List<String> signs) {
        String menu = scanMenuCommand();
        while (!isValidMenu(menu, signs)) {
            menu = scanMenuCommand();
        }
        return menu;
    }

    private String scanMenuCommand() {
        OutputView.printMenuSelectScreen();
        return inputView.getInput();
    }

    private boolean isValidMenu(String menu, List<String> signs) {
        try {
            validateMenu(menu, signs);
            return true;
        } catch (NonExistentMenuException menuError) {
            System.out.println(menuError.getMessage());
            return false;
        }
    }

    private boolean validateMenu(String menu, List<String> signs) {
        if (!signs.contains(menu)) {
            throw new NonExistentMenuException();
        }
        return true;
    }

    private SubMenu getSubMenu(String menuSign) {
        return mainMenu.get(menuSign);
    }
}
