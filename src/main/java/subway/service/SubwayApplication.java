package subway.service;

import subway.userinterface.mainmenu.MainMenuView;

import java.util.Scanner;

public class SubwayApplication {

    public static void run(Scanner scanner) {
        MainMenuView.getInstance().printMenu();
        MainMenuView.getInstance().getUserInput(scanner);
    }
}
