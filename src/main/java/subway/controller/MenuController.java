package subway.controller;

import subway.domain.MenuRepository;
import subway.domain.Menu;
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
    private static final Map<String, Menu> mainMenu = new LinkedHashMap<String, Menu>() {
        {
            put(STATION_MANAGEMENT_SIGN, MenuRepository.stationMenu);
            put(LINE_MANAGEMENT_SIGN, MenuRepository.lineMenu);
            put(EDGE_MANAGEMENT_SIGN, MenuRepository.edgeMenu);
            put(LINE_MAP_SIGN, MenuRepository.lineMap);
            put(QUIT_SIGN, MenuRepository.quit);
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
            runAction(getSubMenu(selectedMenus.get(SUB_MENU_INDEX)));
            return NORMAL_SIGN;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ERROR_SIGN;
        }
    }

    private boolean isQuit() {
        Menu menu = getSubMenu(selectedMenus.get(SUB_MENU_INDEX));
        if (menu == MenuRepository.quit) {
            return true;
        }
        return false;
    }

    private void runAction(Menu menu) {
        if (!MenuRepository.isCategoricalMenu(menu)) {
            MenuRepository.runNonCategoricalAction(menu);
            return;
        }
        boolean backAction = !MenuRepository.runCategoricalAction(inputView, menu, selectedMenus.get(SUB_MENU_ACTION_INDEX));
        if (backAction) {
            selectedMenus.clear();
        }
    }

    public void scanMenu() {
        String selectedMenuSign = scanMainMenu();
        if (MenuRepository.isCategoricalMenu(getSubMenu(selectedMenuSign))) {
            scanSubMenu(mainMenu.get(selectedMenuSign));
        }
    }

    private String scanMainMenu() {
        OutputView.printMainScreen();
        List<String> mainMenuSigns = new ArrayList<String> (mainMenu.keySet());
        String selectedMainMenu = scanValidMenu(mainMenuSigns);
        selectedMenus.add(selectedMainMenu);
        return selectedMainMenu;
    }

    private void scanSubMenu(Menu menu) {
        OutputView.printSubScreen(menu);
        String selectedSubMenu = scanValidMenu(menu.getActionSigns());
        selectedMenus.add(selectedSubMenu);
    }

    private String scanValidMenu(List<String> signs) {
        String menu;
        do {
            menu = scanMenuCommand();
        } while (!isValidMenu(menu, signs));
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

    private Menu getSubMenu(String menuSign) {
        return mainMenu.get(menuSign);
    }
}
