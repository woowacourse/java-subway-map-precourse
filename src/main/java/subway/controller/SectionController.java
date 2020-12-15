package subway.controller;

import subway.menu.SectionMenu;
import subway.view.Input;

public class SectionController {
    public static void section() {
    	SubwayController.output.printSectionMenu();
    	SectionMenu.execute(Input.chooseFunction());
    }
}
