package subway.manager;

import subway.controller.StationController;
import subway.view.Input;
import subway.view.Output;
import subway.manager.menu.StationMenu;

public class StationManager {

    public static void run() {
        StationMenu stationMenu;
        do {
            StationMenu.printMenu();
            stationMenu = chooseMenu();
            stationMenu.execute(StationController.getInstance());
        } while (stationMenu.isBack());
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
