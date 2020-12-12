package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.SectionText;

public class SectionController {
    private static String CONTROLLER_INDEX = "3";
    private static String RESISTER_INDEX = "1";
    private static String DELETE_INDEX = "2";

    public void run(InputView inputView) {
        OutputView.printFunctionTitle(SectionText.functionTitle());
        OutputView.printFunctionList(SectionText.functionList());
        OutputView.printInputFunctionIndex();
        callFunction(inputView.getInputFunctionIndex(SectionText.functionIndexList()));
    }

    private void callFunction(String functionIndex) {
        if (functionIndex.equals(RESISTER_INDEX)) {
            registerSection();
        }
        if (functionIndex.equals(DELETE_INDEX)) {
            deleteSection();
        }
        if (functionIndex.equals(MainController.getControllerIndex())) {
            goBackToMain();
        }
    }

    private void registerSection() {

    }

    private void deleteSection() {

    }

    private void goBackToMain() {

    }

    public static String getControllerIndex() {
        return CONTROLLER_INDEX;
    }
}
