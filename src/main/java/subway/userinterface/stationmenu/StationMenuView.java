package subway.userinterface.stationmenu;

import subway.userinterface.Menu;
import subway.userinterface.MenuView;
import subway.userinterface.ReturnController;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class StationMenuView implements MenuView {

    private static StationMenuView stationMenuView;
    public static LinkedHashMap<String, Menu> stationMenu = new LinkedHashMap<>();
    private static StationViewInputController stationViewInputController = new StationViewInputController();
    private static StationViewOutputController stationViewOutputController = new StationViewOutputController();

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
        stationViewOutputController.printMainMenu(stationMenu);
    }

    @Override
    public void getUserInput(Scanner scanner) {
        stationViewInputController.getUserInput(scanner);
    }
}
