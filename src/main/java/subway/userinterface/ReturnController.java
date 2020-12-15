package subway.userinterface;

import java.util.Scanner;

public class ReturnController implements Menu {
    private final static String MENU_NAME = "B. 돌아가기";
    private final static String MENU_KEY = "B";
    private static ReturnController returnController;

    private ReturnController() {}

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    @Override
    public void run(Scanner scanner) {}

    public static Menu getInstance() {
        if (returnController == null) {
            returnController = new ReturnController();
        }
        return returnController;
    }
}
