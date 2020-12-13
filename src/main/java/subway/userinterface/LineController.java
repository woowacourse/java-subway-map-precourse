package subway.userinterface;

public class LineController implements Menu{

    private final static String MENU_NAME = "2. 노선 관리";
    private final static String MENU_KEY = "2";

    private static LineController lineController;

    private LineController() {}

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    public static Menu getInstance() {
        if (lineController == null) {
            lineController = new LineController();
        }

        return lineController;
    }
}
