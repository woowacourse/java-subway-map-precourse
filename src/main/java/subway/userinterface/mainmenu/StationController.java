package subway.userinterface.mainmenu;

import subway.service.MainService;
import subway.userinterface.Menu;
import subway.userinterface.stationmenu.StationMenuView;

import java.util.Scanner;

public class StationController implements Menu {

    private static final String MENU_NAME = "1. 역 관리";
    private static final String MENU_KEY = "1";
    private static StationController stationController;

    private StationController() {}

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    public static Menu getInstance() {
        if (stationController == null) {
            stationController = new StationController();
        }

        return stationController;
    }

    @Override
    public void run(Scanner scanner) {
        String userSelectMenu;
        StationMenuView.getInstance().printMenu();

        try {
            userSelectMenu = StationMenuView.getInstance().getUserInput(scanner);
            MainService.getInstance().selectMenu(
                    StationMenuView.stationMenu, userSelectMenu, scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.run(scanner);
        }
    }
}
