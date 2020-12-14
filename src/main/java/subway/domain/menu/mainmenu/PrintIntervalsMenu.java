package subway.domain.menu.mainmenu;

import subway.userinterface.Info;

import java.util.Scanner;

public class PrintIntervalsMenu implements Menu {
    public static final String MENU_BUTTON = "4";

    @Override
    public void run(Scanner scanner) {
        Info.printIntervals();
    }
}
