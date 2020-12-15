package subway.controller;

import subway.InitialSetter;
import subway.domain.SubwayMap;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.SubwayMapView;

public class MainController {
    private static final String MAIN_MENU = "Main";
    private static final String STATION_MENU = "1";
    private static final String LINE_MENU = "2";
    private static final String SECTION_MENU = "3";
    private static final String SUBWAY_MAP_MENU = "4";
    private static final String QUIT = "Q";

    private String selection;

    public void run() {
        final InitialSetter initialSetter = new InitialSetter();
        initialSetter.setInitialSubwayInfo();
        goToMainMenu();
    }

    private void goToMainMenu() {
        do {
            OutputView.printMainMenu();
            selection = InputView.receiveMenu(MAIN_MENU);
            goToStationMenuIfUserSelect();
            goToLineMenuIfUserSelect();
            goToSectionMenuIfUserSelect();
            goToSubwayMapIfUserSelect();
        } while (!isQuit());
    }

    private void goToStationMenuIfUserSelect() {
        if (selection.equals(STATION_MENU)) {
            StationController stationController = new StationController();
            stationController.goToMenu();
        }
    }

    private void goToLineMenuIfUserSelect() {
        if (selection.equals(LINE_MENU)) {
            LineController lineController = new LineController();
            lineController.goToMenu();
        }
    }

    private void goToSectionMenuIfUserSelect() {
        if (selection.equals(SECTION_MENU)) {
            SectionController sectionController = new SectionController();
            sectionController.goToMenu();
        }
    }

    private void goToSubwayMapIfUserSelect() {
        if (selection.equals(SUBWAY_MAP_MENU)) {
            SubwayMap subwayMap = new SubwayMap();
            SubwayMapView.printMap(subwayMap.makeSubwayMap());
        }
    }

    private boolean isQuit() {
        if (selection.equals(QUIT)) {
            OutputView.printQuit();
            return true;
        }
        return false;
    }
}
