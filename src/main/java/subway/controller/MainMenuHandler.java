package subway.controller;

import subway.menu.StationMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class MainMenuHandler {
    public static final int ZERO = 0;

    public static void stationManage() {
        OutputView.showStationMenu();
        StationMenu.findByCommand(InputView.nextLine());
    }

    public static void lineManage() {
        OutputView.showStationMenu();
        StationMenu.findByCommand(InputView.nextLine());
    }

    public static void sectionManage() {
        OutputView.showStationMenu();
        StationMenu.findByCommand(InputView.nextLine());
    }

    public static void showSubwayMap() {
        OutputView.showStationMenu();
        StationMenu.findByCommand(InputView.nextLine());
    }

    public static void end(){
        System.exit(ZERO);
    }

}
