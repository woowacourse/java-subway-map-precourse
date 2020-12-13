package subway.userinterface.linemenu;

import subway.userinterface.Menu;

import java.util.Scanner;

public class LineRegisterController implements Menu {

    private final static String MENU_NAME = "1. 노선 등록";
    private final static String MENU_KEY = "1";

    private static LineRegisterController lineRegisterController;

    public static Menu getInstance() {
        if (lineRegisterController == null) {
            lineRegisterController = new LineRegisterController();
        }

        return lineRegisterController;
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    @Override
    public void run(Scanner scanner) {

    }
}
