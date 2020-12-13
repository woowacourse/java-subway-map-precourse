package subway.userinterface;

public class LineController implements Menu{

    private final static String MENU_NAME = "2. 노선 관리";

    private static LineController lineController;

    private LineController() {}

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    public static Menu getInstance() {
        if (lineController == null) {
            lineController = new LineController();
        }

        return lineController;
    }
}
