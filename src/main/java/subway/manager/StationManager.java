package subway.manager;

import subway.controller.StationController;
import subway.view.Input;
import subway.view.Output;
import subway.manager.menu.StationMenu;
import java.util.Scanner;

public class StationManager {

    public static void run() {
        Output.printNewLine();
        StationMenu.printMenu();
        StationMenu stationMenu = chooseMenu();
        stationMenu.execute(StationController.getInstance());
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
