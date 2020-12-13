package subway.userinterface.stationmenu;

import subway.userinterface.Menu;

public class StationDeleteController implements Menu {

    private final static String MENU_NAME = "2. 역 삭제";
    private final static String MENU_KEY = "2";

    private static StationDeleteController stationDeleteController;

    private StationDeleteController() {}

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    public static Menu getInstance() {
        if (stationDeleteController == null) {
            stationDeleteController = new StationDeleteController();
        }

        return stationDeleteController;
    }
}
