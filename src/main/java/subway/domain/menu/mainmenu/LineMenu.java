package subway.domain.menu.mainmenu;

import subway.userinterface.ApplicationMenu;

import java.util.Scanner;

public class LineMenu implements Menu {
    public static final String MENU_BUTTON = "2";

    @Override
    public void run(Scanner scanner) {
        ApplicationMenu.printLineMenu();
        String lineInput = scanner.next();
    }
}
