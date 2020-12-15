package subway.controller;

import java.util.Scanner;
import subway.views.MainView;

public class SubwayMapController {

    public static void start(Scanner scanner) {
        SubwayMapInitializer.initializeStation();
        SubwayMapInitializer.initializeLine();
        SubwayMapInitializer.initializeLineSecond();
        SubwayMapInitializer.initializeLineThird();
        SubwayMapInitializer.initializeLineShinbundang();
        MainView.showSelectManager(scanner);
    }
}
