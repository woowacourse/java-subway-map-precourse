package subway.control;

import subway.view.MainView;

import java.util.Scanner;

public class MainControlCenter {

    public MainControlCenter() {

    }

    public void startMainControl(Scanner scanner) {
        showMainMenu();
    }

    public void showMainMenu() {
        MainView mainView = new MainView();
        mainView.printMainMenu();
    }
}
