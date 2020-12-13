package subway.userinterface;

public class IntervalController implements Menu {

    private final static String MENU_NAME = "3. 구간 관리";

    private static IntervalController intervalController;

    private IntervalController() {}

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    public static Menu getInstance() {
        if (intervalController == null) {
            intervalController = new IntervalController();
        }

        return intervalController;
    }
}
