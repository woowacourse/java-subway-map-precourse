package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.Screen;

public class MainController {
    private static StationController stationController = new StationController();
    private static LineController lineController = new LineController();
    private static SectionController sectionController = new SectionController();
    private static MapController mapController = new MapController();

    private MainController() {
    }

    public static void run() {
        OutputView.printTitle(Screen.MAIN.getTitle());
        OutputView.printFunctionList(Screen.MAIN.getFunctionList());
        OutputView.printInputFunctionIndex();
        shiftFunctionScreen(InputView.getInputFunctionIndex(Screen.MAIN.getIndexList()));
    }

    private static void shiftFunctionScreen(String functionIndex) {
        if (functionIndex.equals(Screen.STATION.getIndex())) {
            stationController.run();
        }
        if (functionIndex.equals(Screen.LINE.getIndex())) {
            lineController.run();
        }
        if (functionIndex.equals(Screen.SECTION.getIndex())) {
            sectionController.run();
        }
        if (functionIndex.equals(Screen.MAP.getIndex())) {
            mapController.run();
        }
        if (functionIndex.equals(Screen.QUIT.getIndex())) {
        }
    }
}
