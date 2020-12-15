package subway.controller;

import subway.menu.LineMenu;
import subway.menu.SectionMenu;
import subway.menu.StationMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class MainMenuHandler {
    public static final int ZERO = 0;

    public static void stationManage() {
        OutputView.showStationMenu();
        StationMenu menuAction = StationMenu.findByCommand(InputView.nextLine());
        menuAction.run();
    }

    public static void lineManage() {
        OutputView.showLineMenu();
        LineMenu menuAction = LineMenu.findByCommand(InputView.nextLine());
        menuAction.run();
    }

    public static void sectionManage() {
        OutputView.showSectionMenu();
        SectionMenu menuAction = SectionMenu.findByCommand(InputView.nextLine());
        menuAction.run();
    }

    public static void showSubwayMap() {
    }

    public static void end(){
        System.exit(ZERO);
    }

}
