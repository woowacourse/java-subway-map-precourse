package subway.service;

import subway.userinterface.Menu;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class MainService {

    private static MainService mainService;

    private Menu selectedMenu;

    private MainService() {}

    public static MainService getInstance() {
        if (mainService == null) {
            mainService = new MainService();
        }

        return mainService;
    }

    public void selectMenu(LinkedHashMap<String, Menu> menuList,
                           String menuKey, Scanner scanner) throws IllegalArgumentException {
        selectedMenu = menuList.get(menuKey);
        runSelectMenu(scanner);
    }

    private void runSelectMenu(Scanner scanner) throws IllegalArgumentException {
        selectedMenu.run(scanner);
    }
}
