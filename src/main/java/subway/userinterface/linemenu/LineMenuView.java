package subway.userinterface.linemenu;

import subway.userinterface.*;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class LineMenuView implements MenuView {

    private final static String MENU_INTRO = "\n## 노선 관리 화면";

    private static LineMenuView lineMenuView;
    private static ViewInputController viewInputController = new ViewInputController();


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
                LineRegisterController.getInstance());
        lineMenu.put(LineDeleteController.getInstance().getMenuKey(),
                LineDeleteController.getInstance());
        lineMenu.put(LineLookupController.getInstance().getMenuKey(),
                LineLookupController.getInstance());
        lineMenu.put(ReturnController.getInstance().getMenuKey(),
                ReturnController.getInstance());
    }

    @Override
    public void printMenu() {
        OutputController.printMainMenu(lineMenu, MENU_INTRO);
    }

    @Override
    public String getUserInput(Scanner scanner) {
        return viewInputController.getUserInput(scanner);
    }
}
