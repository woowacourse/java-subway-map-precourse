package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.LineText;

public class LineController {
    private static String CONTROLLER_INDEX = "2";
    private static String RESISTER_INDEX = "1";
    private static String DELETE_INDEX = "2";
    private static String LOOK_UP_INDEX = "3";

    public void run(InputView inputView) {
        OutputView.printFunctionTitle(LineText.getFunctionTitle());
        OutputView.printFunctionList(LineText.getFunctionList());
        OutputView.printInputFunctionIndex();
        callFunction(inputView.getInputFunctionIndex(LineText.getFunctionIndexList()));
    }

    private void callFunction(String functionIndex) {
        if (functionIndex.equals(RESISTER_INDEX)) {
            registerLine();
        }
        if (functionIndex.equals(DELETE_INDEX)) {
            deleteLine();
        }
        if (functionIndex.equals(LOOK_UP_INDEX)) {
            lookUpLine();
        }
        if (functionIndex.equals(MainController.getControllerIndex())) {
            goBackToMain();
        }
    }

    private void registerLine() {

    }

    private void deleteLine() {

    }

    private void lookUpLine() {

    }

    private void goBackToMain() {

    }

    public String getControllerIndex() {
        return CONTROLLER_INDEX;
    }
}
