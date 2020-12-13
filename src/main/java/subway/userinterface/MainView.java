package subway.userinterface;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class MainView {

    private static MainView mainView;
    public static LinkedHashMap<String, Menu> mainMenu = new LinkedHashMap<>();

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
        mainMenu.put(StationController.getInstance().getMenuKey(), StationController.getInstance());
        mainMenu.put(LineController.getInstance().getMenuKey(), LineController.getInstance());
        mainMenu.put(IntervalController.getInstance().getMenuKey(), IntervalController.getInstance());
        mainMenu.put(SubwayInfoController.getInstance().getMenuKey(), SubwayInfoController.getInstance());
        mainMenu.put(ExitController.getInstance().getMenuKey(), ExitController.getInstance());
    }

    public void printMainMenu() {
        MainViewOutputController.printMainMenu(mainMenu);
    }

    public void getUserInput(Scanner scanner) {
        MainViewInputController.getMainMenuInput(scanner);
    }

}
