package subway.userinterface.linemenu;

import subway.userinterface.Menu;
import subway.userinterface.MenuView;
import subway.userinterface.OutputController;
import subway.userinterface.ReturnController;
import subway.userinterface.stationmenu.StationDeleteController;
import subway.userinterface.stationmenu.StationLookupController;
import subway.userinterface.stationmenu.StationMenuView;
import subway.userinterface.stationmenu.StationRegisterController;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class LineMenuView implements MenuView {

    private final static String MENU_INTRO = "\n## 노선 관리 화면";

    private static LineMenuView lineMenuView;

    public static LinkedHashMap<String, Menu> lineMenu = new LinkedHashMap<>();

    private LineMenuView() {
        setMenu();
    }

    public static LineMenuView getInstance() {
        if (lineMenuView == null) {
            lineMenuView = new LineMenuView();
        }

        return lineMenuView;
    }

    private void setMenu() {
        lineMenu.put(LineRegisterController.getInstance().getMenuKey(),
                StationRegisterController.getInstance());
        lineMenu.put(LineDeleteController.getInstance().getMenuKey(),
                StationDeleteController.getInstance());
        lineMenu.put(LineLookupController.getInstance().getMenuKey(),
                StationLookupController.getInstance());
        lineMenu.put(ReturnController.getInstance().getMenuKey(),
                ReturnController.getInstance());
    }

    @Override
    public void printMenu() {
        OutputController.printMainMenu(lineMenu, MENU_INTRO);
    }

    @Override
    public String getUserInput(Scanner scanner) {
        return null;
    }
}
