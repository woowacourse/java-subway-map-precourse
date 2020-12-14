package subway.manager;

import subway.view.Input;
import subway.manager.menu.MainMenu;
import subway.view.Output;
import java.util.Scanner;

public class MainManager {

    private MainManager() {
    }

    public static void run(Scanner scanner) {
        MainMenu mainMenu;
        do {
            Output.printNewLine();
            MainMenu.printMenu();
            mainMenu = chooseMenu(scanner);
            mainMenu.execute(scanner);
        } while (mainMenu.isExit());
    }

    private static MainMenu chooseMenu(Scanner scanner) {
        try {
            return MainMenu.getMainMenuType(Input.input(scanner, Input.CHOOSE_FUNCTION_MESSAGE));
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return chooseMenu(scanner);
        }
    }
}
