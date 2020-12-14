package subway.manager;

import subway.view.Input;
import subway.manager.menu.MainMenu;
import subway.view.Output;
import java.util.Scanner;

public class MainManager {

    private MainManager() {
    }

    public static void run() {
        MainMenu mainMenu;
        do {
            Output.printNewLine();
            MainMenu.printMenu();
            mainMenu = chooseMenu();
            mainMenu.execute();
        } while (mainMenu.isExit());
    }

    private static MainMenu chooseMenu() {
        try {
            return MainMenu.getMainMenuType(Input.input(Input.CHOOSE_FUNCTION_MESSAGE));
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return chooseMenu();
        }
    }
}
