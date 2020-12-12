package subway.domain.menu.mainmenu;

import subway.userinterface.ApplicationMenu;

import java.util.Scanner;

public class StationMenu implements Menu {
    public static final String MENU_BUTTON = "1";

    @Override
    public void run(Scanner scanner) {
        ApplicationMenu.printStationMenu();
        String stationInput = scanner.next();
    }
}
