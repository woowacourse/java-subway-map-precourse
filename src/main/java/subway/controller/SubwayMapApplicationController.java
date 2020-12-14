package subway.controller;

import java.util.Scanner;
import subway.view.InputView;
import subway.view.SubwayMapOutputView;

public class SubwayMapApplicationController {
    public static void run(Scanner scanner) {
        InputView.setScanner(scanner);
        MenuController.callMainMenu();
    }
    
    public static void showSubwayMap() {
        SubwayMapOutputView.printSubwayMap();
        MenuController.callMainMenu();
    }

    public static void Quit() {
        System.exit(0);
    }
}
