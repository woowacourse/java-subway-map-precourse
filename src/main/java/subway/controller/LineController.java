package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.LineText;

public class LineController {
    private static String CONTROLLER_INDEX = "2";

    private LineController() {
    }

    public static void run(InputView inputView) {
        OutputView.printFunctionTitle(LineText.getFunctionTitle());
        OutputView.printFunctionList(LineText.getFunctionList());
        OutputView.printInputFunctionIndex();
        shiftFunctionScreen(inputView.getInputFunctionIndex(LineText.getFunctionIndexList()));
    }

    private static void shiftFunctionScreen(String functionIndex) {
    }

    public static String getControllerIndex() {
        return CONTROLLER_INDEX;
    }
}
