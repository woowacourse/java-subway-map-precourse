package subway.controller;

import java.util.Scanner;
import subway.view.BaseView;
import utils.ScriptUtils;

public class MainController {
    private MainController() {}

    public static void startProgram(Scanner scanner) {
        BaseView mainView = new BaseView();
        mainView.printMenu(ScriptUtils.MAIN_MENU);
        mainView.selectMenu(scanner);
    }
}
