package subway.manager;

import subway.controller.StationController;
import subway.view.Input;
import subway.view.Output;
import subway.manager.menu.StationMenu;

public class StationManager {

    public static void run() {
        do {
            StationMenu.printMenu();
            chooseMenu().execute(StationController.getInstance());
        } while (StationMenu.isBack());
    }

    private static StationMenu chooseMenu() {
        try {
            return StationMenu.getStationMenuType(Input.input(Input.CHOOSE_FUNCTION_MESSAGE));
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return chooseMenu();
        }
    }
}
