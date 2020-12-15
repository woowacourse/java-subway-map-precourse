package subway.userinterface.intervalmenu;

import subway.userinterface.Menu;
import subway.userinterface.MenuView;
import subway.userinterface.OutputController;
import subway.userinterface.ReturnController;
import subway.userinterface.ViewInputController;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class IntervalMenuView implements MenuView {
    private final static String MENU_INTRO = "\n## 구간 관리 화면";
    private static IntervalMenuView intervalMenuView;
    public static LinkedHashMap<String, Menu> intervalMenu = new LinkedHashMap<>();
    private static ViewInputController viewInputController = new ViewInputController();

    private IntervalMenuView() {
        setMenu();
    }

    public static IntervalMenuView getInstance() {
        if (intervalMenuView == null) {
            intervalMenuView = new IntervalMenuView();
        }
        return intervalMenuView;
    }

    private void setMenu() {
        intervalMenu.put(IntervalRegisterController.getInstance().getMenuKey(),
                IntervalRegisterController.getInstance());
        intervalMenu.put(IntervalDeleteController.getInstance().getMenuKey(),
                IntervalDeleteController.getInstance());
        intervalMenu.put(ReturnController.getInstance().getMenuKey(),
                ReturnController.getInstance());
    }

    @Override
    public void printMenu() {
        OutputController.printMainMenu(intervalMenu, MENU_INTRO);
    }

    @Override
    public String getUserInput(Scanner scanner) {
        return viewInputController.getUserInput(scanner);
    }
}
