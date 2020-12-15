package subway.manager;

import subway.manager.menu.LineMenu;
import subway.manager.menu.SectionMenu;

public class SectionManager{

    public static void run() {
        do {
            SectionMenu.initMenuStatus();
            SectionMenu.printMenu();
        } while (LineMenu.isRestart());
    }
}
