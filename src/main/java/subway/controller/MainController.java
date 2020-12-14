package subway.controller;

import subway.domain.SubwayMap;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.SubwayMapView;

public class MainController {
    public static void goToMain() {
        OutputView.printMainMenu();
        String selection = InputView.receiveMenu("Main");
        if (selection.equals("1")) {
            StationController.goToStationMenu();
        }
        if (selection.equals("2")) {
            LineController.goToLineMenu();
        }
        if (selection.equals("3")) {
            SectionController.goToSectionMenu();
        }
        if (selection.equals("4")) {
            SubwayMap subwayMap = new SubwayMap();
            SubwayMapView.printMap(subwayMap.makeSubwayMap());
        }
        if (selection.equals("Q")) {
            OutputView.printQuit();
            return;
        }
        goToMain();
    }
}
