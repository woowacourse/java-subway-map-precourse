package subway.controller;

import subway.InitialSetter;
import subway.domain.SubwayMap;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.SubwayMapView;

public class MainController {
    private String selection;

    public void run() {
        final InitialSetter initialSetter = new InitialSetter();
        initialSetter.setInitialSubwayInfo();
        goToMainMenu();
    }

    private void goToMainMenu() {
        do {
            OutputView.printMainMenu();
            selection = InputView.receiveMenu("Main");
            goToStationMenuIfUserSelect();
            goToLineMenuIfUserSelect();
            goToSectionMenuIfUserSelect();
            goToSubwayMapIfUserSelect();
        } while (!isQuit());
    }

    private void goToStationMenuIfUserSelect() {
        if (selection.equals("1")) {
            StationController stationController = new StationController();
            stationController.goToMenu();
        }
    }

    private void goToLineMenuIfUserSelect() {
        if (selection.equals("2")) {
            LineController lineController = new LineController();
            lineController.goToMenu();
        }
    }

    private void goToSectionMenuIfUserSelect() {
        if (selection.equals("3")) {
            SectionController sectionController = new SectionController();
            sectionController.goToMenu();
        }
    }

    private void goToSubwayMapIfUserSelect() {
        if (selection.equals("4")) {
            SubwayMap subwayMap = new SubwayMap();
            SubwayMapView.printMap(subwayMap.makeSubwayMap());
        }
    }

    private boolean isQuit() {
        if (selection.equals("Q")) {
            OutputView.printQuit();
            return true;
        }
        return false;
    }
}
