package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.StationText;

public class StationController {
    private static String CONTROLLER_INDEX = "1";

    private StationController() {
    }

    public static void run(InputView inputView) {
        OutputView.printFunctionTitle(StationText.getFunctionTitle());
        OutputView.printFunctionList(StationText.getFunctionList());
        OutputView.printInputFunctionIndex();
        shiftFunctionScreen(inputView.getInput(StationText.getFunctionIndexList()));
    }

    private static void shiftFunctionScreen(String functionIndex) {
    }

    public static String getControllerIndex() {
        return CONTROLLER_INDEX;
    }
}
