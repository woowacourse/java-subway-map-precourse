package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.MainText;

public class MainController {
    private static String CONTROLLER_INDEX = "B";
    private static String FINISH_INDEX = "Q";
    private static StationController stationController = new StationController();
    private static LineController lineController = new LineController();
    private static SectionController sectionController = new SectionController();
    private static MapController mapController = new MapController();

    private MainController() {
    }

    public static void run(InputView inputView) {
        OutputView.printFunctionTitle(MainText.getFunctionTitle());
        OutputView.printFunctionList(MainText.getFunctionList());
        OutputView.printInputFunctionIndex();
        shiftFunctionScreen(inputView, inputView.getInputFunctionIndex(MainText.getFunctionIndexList()));
    }

    private static void shiftFunctionScreen(InputView inputView, String functionIndex) {
        System.out.println();
        if (functionIndex.equals(stationController.getControllerIndex())) {
            stationController.run(inputView);
        }
        if (functionIndex.equals(lineController.getControllerIndex())) {
            lineController.run(inputView);
        }
        if (functionIndex.equals(sectionController.getControllerIndex())) {
            sectionController.run(inputView);
        }
        if (functionIndex.equals(mapController.getControllerIndex())) {
            mapController.run();
        }
        if (functionIndex.equals(FINISH_INDEX)) {
        }
    }

    public static String getControllerIndex() {
        return CONTROLLER_INDEX;
    }
}
