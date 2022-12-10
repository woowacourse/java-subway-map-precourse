package subway.controllers;

import contants.MainMenu;
import view.OutputView;

public class MainController {
    public void run() {
        OutputView.printMainMenu(MainMenu.getWholeMenu());
    }
}
