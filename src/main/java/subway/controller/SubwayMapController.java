package subway.controller;

import subway.view.SubwayMapOutputView;

public class SubwayMapController {
    public static void showSubwayMap() {
        SubwayMapOutputView.printSubwayMap();
        MenuController.callMainMenu();
    }
}
