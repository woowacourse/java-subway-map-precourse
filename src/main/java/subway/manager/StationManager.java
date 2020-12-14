package subway.manager;

import subway.controller.StationController;
import subway.view.Input;
import subway.view.Output;
import subway.manager.menu.StationMenu;
import java.util.Scanner;

public class StationManager {

    public static void run(Scanner scanner) {
        Output.printNewLine();
        StationMenu.printMenu(scanner);
        StationMenu stationMenu = chooseMenu(scanner);
        stationMenu.execute(StationController.getInstance());
    }

    private static StationMenu chooseMenu(Scanner scanner) {
        try {
            return StationMenu.getStationMenuType(Input.choose(scanner));
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return chooseMenu(scanner);
        }
    }
}
