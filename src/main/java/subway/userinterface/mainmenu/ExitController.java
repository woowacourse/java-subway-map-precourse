package subway.userinterface.mainmenu;

import subway.userinterface.Menu;

public class ExitController implements Menu {

    private final static String MENU_NAME = "Q. 종료";
    private final static String MENU_KEY = "Q";

    private static ExitController exitController;

    private ExitController() {}

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    public static Menu getInstance() {
        if (exitController == null) {
            exitController = new ExitController();
        }

        return exitController;
    }
}
