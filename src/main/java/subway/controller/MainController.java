package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.Screen;

public class MainController {
    private static StationController stationController = new StationController();
    private static LineController lineController = new LineController();
    private static SectionController sectionController = new SectionController();
    private static MapController mapController = new MapController();

    private MainController() {
    }

    public static void run(InputView inputView) {
        OutputView.printTitle(Screen.MAIN.getTitle());
        OutputView.printFunctionList(Screen.MAIN.getFunctionList());
        OutputView.printInputFunctionIndex();
        shiftFunctionScreen(inputView,
                inputView.getInputFunctionIndex(Screen.MAIN.getIndexList()));
    }

    private static void shiftFunctionScreen(InputView inputView, String functionIndex) {
        if (functionIndex.equals(Screen.STATION.getIndex())){
            stationController.run(inputView);
        }
        if (functionIndex.equals(Screen.LINE.getIndex())) {
            lineController.run(inputView);
        }
        if (functionIndex.equals(Screen.SECTION.getIndex())) {
            sectionController.run(inputView);
        }
        if (functionIndex.equals(Screen.MAP.getIndex())) {
            mapController.run(inputView);
        }
        if (functionIndex.equals(Screen.QUIT.getIndex())) {
        }
    }
}
