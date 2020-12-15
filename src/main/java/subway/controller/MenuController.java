package subway.controller;

import subway.domain.menu.Menu;
import subway.domain.menu.MenuRepository;
import subway.domain.menu.MenuType;
import subway.view.InputView;
import subway.view.MenuOutputView;
import subway.view.OutputView;

public class MenuController {
    public static void callMainMenu() {
        showMenu(MenuRepository.getMenu(MenuType.MAIN));
    }

    public static void callStationMenu() {
        showMenu(MenuRepository.getMenu(MenuType.STATION));
    }

    public static void callLineMenu() {
        showMenu(MenuRepository.getMenu(MenuType.LINE));
    }

    public static void callSectionMenu() {
        showMenu(MenuRepository.getMenu(MenuType.SECTION));
    }

    private static void showMenu(Menu menu) {
        MenuOutputView.printMenu(menu);
        selectFunction(menu);
    }

    private static void selectFunction(Menu menu) {
        try {
            MenuOutputView.requestSelectFunction();
            menu.executeMenuItem(InputView.getInput());
        } catch (Exception exception) {
            OutputView.printError(exception);
            selectFunction(menu);
        }
    }
}
