package subway.userinterface.stationmenu;

import subway.userinterface.Menu;

public class StationRegisterController implements Menu {

    private final static String MENU_NAME = "1. 역 등록";
    private final static String MENU_KEY = "1";

    private static StationRegisterController stationRegisterController;

    private StationRegisterController() {}

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    public static Menu getInstance() {
        if (stationRegisterController == null) {
            stationRegisterController = new StationRegisterController();
        }

        return stationRegisterController;
    }
}
