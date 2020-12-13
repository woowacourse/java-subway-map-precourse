package subway.userinterface;

import java.util.ArrayList;
import java.util.List;

public class MainView {

    private final static String INTRO_STATEMENT = "## 메인 화면";
    private final static int NUM_OF_MENU = 5;

    private static MainView mainView;
    public static List<Menu> mainMenu = new ArrayList<>();

    private MainView() {
        setMenu();
    }

    public static MainView getInstance() {
        if (mainView == null) {
            mainView = new MainView();
        }

        return mainView;
    }

    private void setMenu() {
        mainMenu.add(StationController.getInstance());
        mainMenu.add(LineController.getInstance());
        mainMenu.add(IntervalController.getInstance());
        mainMenu.add(SubwayInfoController.getInstance());
        mainMenu.add(ExitController.getInstance());
    }

    public static void printMainMenu() {
        System.out.println(INTRO_STATEMENT);

        for (int m = 0; m < NUM_OF_MENU; m++) {
            System.out.println(mainMenu.get(m).getMenuName());
        }

        System.out.print("/n");
    }

}
