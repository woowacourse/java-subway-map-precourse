package subway.domain;

import subway.domain.menu.MainMenu;
import subway.domain.management.StationManagement;

import java.util.Scanner;

public class Services {

    public static void doService(String inputData, Scanner scanner) {
        if (inputData.equals(MainMenu.STATION.getOrder())) {
            StationManagement.doStationManagement(scanner);
            return;
        }
        if (inputData.equals(MainMenu.LINE.getOrder())) {

        }
        if (inputData.equals(MainMenu.SECTION.getOrder())) {

        }
        if (inputData.equals(MainMenu.MAP.getOrder())) {

        }
    }
}
