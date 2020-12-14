package subway.userinterface.linemenu;

import subway.userinterface.Menu;
import subway.userinterface.OutputController;

import java.util.Scanner;

public class LineLookupController implements Menu {

    private final static String MENU_NAME = "3. 노선 조회";
    private final static String MENU_KEY = "3";

    private static LineLookupController lineLookupController;

    public static Menu getInstance() {
        if (lineLookupController == null) {
            lineLookupController = new LineLookupController();
        }

        return lineLookupController;
    }

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
        OutputController.printLineInfo();
    }
}
