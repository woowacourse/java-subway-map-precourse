package subway.userinterface;

public class StationController implements Menu {

    private final static String MENU_NAME = "1. 역 관리";

    private static StationController stationController;

    private StationController() {}

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    public static Menu getInstance() {
        if (stationController == null) {
            stationController = new StationController();
        }

        return stationController;
    }
}
