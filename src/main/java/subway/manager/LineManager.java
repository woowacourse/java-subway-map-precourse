package subway.manager;

import subway.controller.LineController;
import subway.manager.menu.LineMenu;
import subway.view.Input;
import subway.view.Output;

public class LineManager{

    public static void run() {
        LineMenu lineMenu;
        do {
            Output.printNewLine();
            LineMenu.printMenu();
            lineMenu = chooseMenu();
            lineMenu.execute(LineController.getInstance());
        } while (lineMenu.isBack());
    }

    private static LineMenu chooseMenu() {
        try {
            return LineMenu.getLineMenuType(Input.input(Input.CHOOSE_FUNCTION_MESSAGE));
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return chooseMenu();
        }
    }
}
