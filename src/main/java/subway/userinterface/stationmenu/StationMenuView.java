package subway.userinterface.stationmenu;

import subway.userinterface.*;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class StationMenuView implements MenuView {

    private final static String MENU_INTRO = "\n## 역 관리 화면";

    private static StationMenuView stationMenuView;
    private static ViewInputController viewInputController = new ViewInputController();

    public static LinkedHashMap<String, Menu> stationMenu = new LinkedHashMap<>();

    private StationMenuView() {
        setMenu();
    }

    public static StationMenuView getInstance() {
        if (stationMenuView == null) {
            stationMenuView = new StationMenuView();
        }

        return stationMenuView;
    }

    private void setMenu() {
        stationMenu.put(StationRegisterController.getInstance().getMenuKey(),
                StationRegisterController.getInstance());
        stationMenu.put(StationDeleteController.getInstance().getMenuKey(),
                StationDeleteController.getInstance());
        stationMenu.put(StationLookupController.getInstance().getMenuKey(),
                StationLookupController.getInstance());
        stationMenu.put(ReturnController.getInstance().getMenuKey(),
                ReturnController.getInstance());
    }

    @Override
    public void printMenu() {
        OutputController.printMainMenu(stationMenu, MENU_INTRO);
    }

    @Override
    public String getUserInput(Scanner scanner) throws IllegalArgumentException {
        return viewInputController.getUserInput(scanner);
    }
}
