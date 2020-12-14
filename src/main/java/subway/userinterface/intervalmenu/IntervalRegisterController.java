package subway.userinterface.intervalmenu;

import subway.userinterface.Menu;

import java.util.Scanner;

public class IntervalRegisterController implements Menu {

    private static final String MENU_NAME = "2. 구간 삭제";
    private static final String MENU_KEY = "2";
    private static IntervalRegisterController intervalRegisterController;

    public static Menu getInstance() {
        if (intervalRegisterController == null) {
            intervalRegisterController = new IntervalRegisterController();
        }

        return intervalRegisterController;
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
