package subway.controller;

import subway.domain.Action;
import subway.domain.MenuRepository;
import subway.domain.Menu;
import subway.domain.exception.NonExistentMenuException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class Kiosk {
    private static final String STATION_MANAGEMENT_SIGN = "1";
    private static final String LINE_MANAGEMENT_SIGN = "2";
    private static final String EDGE_MANAGEMENT_SIGN = "3";
    private static final String LINE_MAP_SIGN = "4";
    private static final String QUIT_SIGN = "Q";
    private static final int MENU_INDEX = 0;
    private static final int ACTION_INDEX = 1;
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

    private final ArrayList<String> selectedMenus;
    private final InputView inputView;

    public Kiosk(InputView inputView) {
        this.inputView = inputView;
        this.selectedMenus = new ArrayList<String>();
    }

    public boolean run() {
        String status = runMenu();
        while (status.equals(ERROR_SIGN)) {
            removeAction();
            scanSubMenu(getMenu(selectedMenus.get(MENU_INDEX)));
            status = runMenu();
        }
        if (status.equals(QUIT_SIGN)) {
            return false;
        }
        return true;
    }

    private String runMenu() {
        try {
            if (isQuit()) {
                return QUIT_SIGN;
            }
            runAction(getMenu(selectedMenus.get(MENU_INDEX)));
            return NORMAL_SIGN;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ERROR_SIGN;
        }
    }

    private boolean isQuit() {
        Menu menu = getMenu(selectedMenus.get(MENU_INDEX));
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
        boolean backAction = !MenuRepository.runCategoricalAction(inputView, menu, selectedMenus.get(ACTION_INDEX));
        if (backAction) {
            orderClear();
        }
    }

    private void removeAction() {
        selectedMenus.remove(ACTION_INDEX);
    }

    public void scan() {
        String selectedMenuSign = scanMainMenu();
        if (MenuRepository.isCategoricalMenu(getMenu(selectedMenuSign))) {
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
        String selectedSubMenu = scanValidAction(menu);
        selectedMenus.add(selectedSubMenu);
    }

    private String scanValidMenu(List<String> signs) {
        String menu;
        do {
            menu = scanMenuCommand();
        } while (!isValidMenu(menu, signs));
        return menu;
    }

    private String scanValidAction(Menu menu) {
        String action;
        do {
            action = scanMenuCommand();
        } while (!isValidAction(menu, action));
        return action;
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

    private boolean isValidAction(Menu menu, String actionSign) {
        try {
            validateAction(menu, actionSign);
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

    private boolean validateAction(Menu menu, String actionSign) {
        if (!menu.includeAction(actionSign)) {
            throw new NonExistentMenuException();
        }
        return true;
    }

    public void orderClear() {
        selectedMenus.clear();
    }

    private Menu getMenu(String menuSign) {
        return mainMenu.get(menuSign);
    }
}
