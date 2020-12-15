package subway.manager;

import subway.view.Input;
import subway.manager.menu.MainMenu;
import subway.view.Output;

public class MainManager {

    private MainManager() {
    }

    public static void run() {
        do {
            MainMenu.printMenu();
            chooseMenu().execute();
        } while (MainMenu.isExit());
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
