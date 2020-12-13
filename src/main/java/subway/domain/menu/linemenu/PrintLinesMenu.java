package subway.domain.menu.linemenu;

import subway.userinterface.Info;

import java.util.Scanner;

public class PrintLinesMenu implements LineManageMenu {
    public static final String MENU_BUTTON = "3";

    @Override
    public void run(Scanner scanner) {
        Info.printLines();
    }
}
