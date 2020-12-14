package subway.manager;

import subway.manager.menu.LineMenu;
import subway.view.Output;

public class LineManager{

    public static void run() {
        Output.printNewLine();
        LineMenu.printMenu();
    }
}
