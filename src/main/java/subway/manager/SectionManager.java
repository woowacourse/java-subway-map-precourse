package subway.manager;

import subway.controller.SectionController;
import subway.manager.menu.LineMenu;
import subway.manager.menu.SectionMenu;
import subway.view.Input;
import subway.view.Output;

public class SectionManager {

    public static void run() {
        do {
            SectionMenu.initMenuStatus();
            SectionMenu.printMenu();
            chooseMenu().execute(SectionController.getInstance());
        } while (SectionMenu.isRestart());
    }

    private static SectionMenu chooseMenu() {
        try {
            return SectionMenu.getSectionMenuType(Input.input(Input.CHOOSE_FUNCTION));
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return chooseMenu();
        }
    }
}
