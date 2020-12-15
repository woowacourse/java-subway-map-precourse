package subway.service.stationservice;

import subway.controller.StationMenuController;

import java.util.Scanner;

public class StationService {
    static void goToMenu(IllegalArgumentException e, Scanner scanner) {
        System.out.println(e.getMessage());
        StationMenuController stationMenuController = StationMenuController.getInstance();
        stationMenuController.mappingMenu(scanner);
    }
}
