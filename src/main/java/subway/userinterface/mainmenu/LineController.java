package subway.userinterface.mainmenu;

import subway.service.MainService;
import subway.userinterface.Menu;
import subway.userinterface.linemenu.LineMenuView;
import java.util.Scanner;

public class LineController implements Menu {
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

    @Override
    public void run(Scanner scanner) {
        String userSelectMenu;
        LineMenuView.getInstance().printMenu();

        try {
            userSelectMenu = LineMenuView.getInstance().getUserInput(scanner);
            MainService.getInstance().selectMenu(
                    LineMenuView.lineMenu, userSelectMenu, scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.run(scanner);
        }
    }

    public static Menu getInstance() {
        if (lineController == null) {
            lineController = new LineController();
        }
        return lineController;
    }
}
