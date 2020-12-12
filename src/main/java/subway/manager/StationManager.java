package subway.manager;

import java.util.Scanner;

import subway.domain.menu.MainMenu;

public class StationManager {
    MainMenu mainMenu;

    public StationManager(Scanner scanner) {
        mainMenu = new MainMenu(scanner);
    }

    public void start() {
        mainMenu.runMainMenu();
    }
}
