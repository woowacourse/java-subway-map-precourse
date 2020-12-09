package subway.control;

import subway.view.MainView;
import subway.view.StationView;

import java.util.Scanner;

public class MainControlCenter {

    public MainControlCenter() {

    }

    public void startMainControl(Scanner scanner) {
        showMainMenu();
        StationView.printStationMenu();
    }

    public void showMainMenu() {
        MainView mainView = new MainView();
        mainView.printMainMenu();
    }



}
