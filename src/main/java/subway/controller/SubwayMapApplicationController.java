package subway.controller;

import subway.view.SubwayMapOutputView;

public class SubwayMapApplicationController {
    public static void run() {
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
