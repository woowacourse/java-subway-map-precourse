package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.SectionText;

public class SectionController {
    private static String CONTROLLER_INDEX = "3";

    private SectionController() {
    }

    public static void run(InputView inputView) {
        OutputView.printFunctionTitle(SectionText.getFunctionTitle());
        OutputView.printFunctionList(SectionText.getFunctionList());
        OutputView.printInputFunctionIndex();
        shiftFunctionScreen(inputView.getInputFunctionIndex(SectionText.getFunctionIndexList()));
    }

    private static void shiftFunctionScreen(String functionIndex) {
    }

    public static String getControllerIndex() {
        return CONTROLLER_INDEX;
    }
}
