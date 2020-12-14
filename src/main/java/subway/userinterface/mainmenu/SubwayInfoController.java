package subway.userinterface.mainmenu;

import subway.userinterface.Menu;

import java.util.Scanner;

public class SubwayInfoController implements Menu {

    private static final String MENU_NAME = "4. 지하철 노선도 출력";
    private static final String MENU_KEY = "4";
    private static SubwayInfoController subwayInfoController;

    private SubwayInfoController() {}

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    @Override
    public void run(Scanner scanner) {}

    public static Menu getInstance() {
        if (subwayInfoController == null) {
            subwayInfoController = new SubwayInfoController();
        }

        return subwayInfoController;
    }
}
