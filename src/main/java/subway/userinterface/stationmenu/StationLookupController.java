package subway.userinterface.stationmenu;

import subway.userinterface.Menu;

import java.util.Scanner;

public class StationLookupController implements Menu {

    private final static String MENU_NAME = "3. 역 조회";
    private final static String MENU_KEY = "3";

    private static StationLookupController stationLookupController;

    private StationLookupController() {}

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

    public static Menu getInstance() {
        if (stationLookupController == null) {
            stationLookupController = new StationLookupController();
        }

        return stationLookupController;
    }
}
