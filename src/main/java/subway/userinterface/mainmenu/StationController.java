package subway.userinterface.mainmenu;

import subway.userinterface.Menu;

public class StationController implements Menu {

    private final static String MENU_NAME = "1. 역 관리";
    private final static String MENU_KEY = "1";

    private static StationController stationController;

    private StationController() {}

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    public static Menu getInstance() {
        if (stationController == null) {
            stationController = new StationController();
        }

        return stationController;
    }
}
