package subway;

import java.util.Scanner;
import subway.view.MainDisplay;
import subway.view.MainMenu;

public class SubwayMap {

    private SubwayMap() {
    }

    public static SubwayMap newSubwayMap() {
        return new SubwayMap();
    }

    public void runnable(Scanner scanner) {
        while (true) {
            MainDisplay.printMenu();
            MainMenu selected = MainDisplay.selectMenu(scanner);
            if (selected == MainMenu.QUIT_PROGRAM) {
                break;
            }
            selected.executeMenu(selected.getMenuKey());
        }
    }
}
