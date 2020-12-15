package subway.domain;

import subway.domain.management.LineManager;
import subway.domain.management.SectionManager;
import subway.domain.menu.MainMenu;
import subway.domain.management.StationManager;

import java.util.Scanner;

public class Services {

    public static void doService(String inputData, Scanner scanner) {
        if (inputData.equals(MainMenu.STATION.getOrder())) {
            StationManager stationManager = new StationManager(scanner);
            stationManager.doStationManagement();
            return;
        }
        if (inputData.equals(MainMenu.LINE.getOrder())) {
            LineManager lineManager = new LineManager(scanner);
            lineManager.doStationManagement();
            return;
        }
        if (inputData.equals(MainMenu.SECTION.getOrder())) {
            SectionManager sectionManager = new SectionManager(scanner);
            sectionManager.doStationManagement();
            return;
        }
        if (inputData.equals(MainMenu.MAP.getOrder())) {

        }
    }
}
