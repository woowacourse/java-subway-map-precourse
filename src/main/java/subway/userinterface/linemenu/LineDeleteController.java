package subway.userinterface.linemenu;

import subway.userinterface.Menu;

import java.util.Scanner;

public class LineDeleteController implements Menu {

    private final static String MENU_NAME = "2. 노선 삭제";
    private final static String MENU_KEY = "2";

    private static LineDeleteController lineDeleteController;

    public static Menu getInstance() {
        if (lineDeleteController == null) {
            lineDeleteController = new LineDeleteController();
        }

        return lineDeleteController;
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
