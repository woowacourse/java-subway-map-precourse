package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.MainText;

public class MainController {
    private static String CONTROLLER_INDEX = "B";
    private static String FINISH_INDEX = "Q";

    private MainController() {
    }

    public static void run(InputView inputView) {
        OutputView.printFunctionTitle(MainText.getFunctionTitle());
        OutputView.printFunctionList(MainText.getFunctionList());
        OutputView.printInputFunctionIndex();
        shiftFunctionScreen(inputView, inputView.getInput(MainText.getFunctionIndexList()));
    }

    private static void shiftFunctionScreen(InputView inputView, String functionIndex) {
        if (functionIndex.equals(StationController.getControllerIndex())) {
            StationController.run(inputView);
        }
        if (functionIndex.equals(LineController.getControllerIndex())) {
            LineController.run(inputView);
        }
        if (functionIndex.equals(SectionController.getControllerIndex())) {
            SectionController.run(inputView);
        }
        if (functionIndex.equals(MapController.getControllerIndex())) {
            MapController.run(inputView);
        }
        if (functionIndex.equals(FINISH_INDEX)) {
        }
    }

    public static String getControllerIndex() {
        return CONTROLLER_INDEX;
    }
}
