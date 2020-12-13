package subway.userinterface;

public class ExitController implements Menu {

    private final static String MENU_NAME = "Q. 종료";

    private static ExitController exitController;

    private ExitController() {}

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    public static Menu getInstance() {
        if (exitController == null) {
            exitController = new ExitController();
        }

        return exitController;
    }
}
