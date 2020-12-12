package subway.domain.menu.mainmenu;

import subway.userinterface.ApplicationMenu;

import java.util.Scanner;

public class IntervalMenu implements Menu {
    public static final String MENU_BUTTON = "3";

    @Override
    public void run(Scanner scanner) {
        ApplicationMenu.printIntervalMenu();
        String intervalInput = scanner.next();
    }
}
