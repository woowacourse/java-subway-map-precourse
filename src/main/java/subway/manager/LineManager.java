package subway.manager;

import subway.controller.LineController;
import subway.manager.menu.LineMenu;
import subway.view.Input;
import subway.view.Output;

public class LineManager {

    public static void run() {
        do {
            LineMenu.initMenuStatus();
            LineMenu.printMenu();
            chooseMenu().execute(LineController.getInstance());
        } while (LineMenu.isRestart());
    }

    private static LineMenu chooseMenu() {
        try {
            return LineMenu.getLineMenuType(Input.input(Input.CHOOSE_FUNCTION));
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return chooseMenu();
        }
    }
}
