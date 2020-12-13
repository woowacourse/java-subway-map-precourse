package subway.userinterface;

public class IntervalController implements Menu {

    private final static String MENU_NAME = "3. 구간 관리";
    private final static String MENU_KEY = "3";

    private static IntervalController intervalController;

    private IntervalController() {}

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    public static Menu getInstance() {
        if (intervalController == null) {
            intervalController = new IntervalController();
        }

        return intervalController;
    }
}
