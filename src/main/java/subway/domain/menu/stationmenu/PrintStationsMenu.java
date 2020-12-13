package subway.domain.menu.stationmenu;

import subway.userinterface.Info;

import java.util.Scanner;

public class PrintStationsMenu implements StationManageMenu{
    public static final String MENU_BUTTON = "3";

    @Override
    public void run(Scanner scanner) {
        Info.printStations();
    }
}
