package subway;

import subway.controller.LineController;
import subway.controller.StationController;
import subway.domain.MainMenu;

public class SubwaySystem {
    private static void subwayInit() {
        StationController.stationInit();
        LineController.lineInit();
    }

    public static void run() {
        subwayInit();
        while (MainMenu.getIsMainMenuRun()) {
            MainMenu.mainMenuRun();
        }
    }
}