package subway.userinterface.mainmenu;

import subway.userinterface.Menu;
import subway.userinterface.MenuView;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class MainMenuView implements MenuView {

    private static MainMenuView mainMenuView;
    public static LinkedHashMap<String, Menu> mainMenu = new LinkedHashMap<>();
    private static MainViewInputController mainViewInputController = new MainViewInputController();

    private MainMenuView() {
        setMenu();
    }

    public static MainMenuView getInstance() {
        if (mainMenuView == null) {
            mainMenuView = new MainMenuView();
        }

        return mainMenuView;
    }

    private void setMenu() {
        mainMenu.put(StationController.getInstance().getMenuKey(),
                StationController.getInstance());
        mainMenu.put(LineController.getInstance().getMenuKey(),
                LineController.getInstance());
        mainMenu.put(IntervalController.getInstance().getMenuKey(),
                IntervalController.getInstance());
        mainMenu.put(SubwayInfoController.getInstance().getMenuKey(),
                SubwayInfoController.getInstance());
        mainMenu.put(ExitController.getInstance().getMenuKey(),
                ExitController.getInstance());
    }

    @Override
    public void printMenu() {
        MainViewOutputController.printMainMenu(mainMenu);
    }

    @Override
    public void getUserInput(Scanner scanner) {
        mainViewInputController.getUserInput(scanner);
    }

}
