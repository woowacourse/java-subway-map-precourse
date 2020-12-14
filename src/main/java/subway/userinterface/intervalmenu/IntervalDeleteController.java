package subway.userinterface.intervalmenu;

import subway.userinterface.Menu;
import subway.userinterface.linemenu.LineDeleteController;

import java.util.Scanner;

public class IntervalDeleteController implements Menu {

    private static final String MENU_NAME = "1. 구간 등록";
    private static final String MENU_KEY = "1";
    private static IntervalDeleteController intervalDeleteController;

    public static Menu getInstance() {
        if (intervalDeleteController == null) {
            intervalDeleteController = new IntervalDeleteController();
        }

        return intervalDeleteController;
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
