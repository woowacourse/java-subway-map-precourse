package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.Screen;

public class MainController {
    private MainController() {
    }

    public static void run() {
        OutputView.printTitle(Screen.MAIN.getTitle());
        OutputView.printFunctionList(Screen.MAIN.getFunctionList());
        shiftFunctionScreen(InputView.getInputFunctionIndex(Screen.MAIN.getIndexList()));
    }

    private static void shiftFunctionScreen(String functionIndex) {
        if (functionIndex.equals(Screen.STATION.getIndex())) {
            StationController.run();
        }
        if (functionIndex.equals(Screen.LINE.getIndex())) {
            LineController.run();
        }
        if (functionIndex.equals(Screen.SECTION.getIndex())) {
            SectionController.run();
        }
        if (functionIndex.equals(Screen.MAP.getIndex())) {
            MapController.run();
        }
        if (functionIndex.equals(Screen.QUIT.getIndex())) {
            InputView.closeScanner();
            System.exit(0);
        }
    }
}
