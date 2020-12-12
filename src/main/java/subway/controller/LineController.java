package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.LineText;

public class LineController {
    private static String CONTROLLER_INDEX = "2";
    private static String RESISTER_INDEX = "1";
    private static String DELETE_INDEX = "2";
    private static String LOOK_UP_INDEX = "3";

    public void run(InputView inputView) {
        OutputView.printFunctionTitle(LineText.functionTitle());
        OutputView.printFunctionList(LineText.functionList());
        OutputView.printInputFunctionIndex();
        callFunction(inputView, inputView.getInputFunctionIndex(LineText.functionIndexList()));
    }

    private void callFunction(InputView inputView, String functionIndex) {
        if (functionIndex.equals(RESISTER_INDEX)) {
            registerLine(inputView);
        }
        if (functionIndex.equals(DELETE_INDEX)) {
            deleteLine(inputView);
        }
        if (functionIndex.equals(LOOK_UP_INDEX)) {
            lookUpLine(inputView);
        }
        if (functionIndex.equals(MainController.getControllerIndex())) {
            goBackToMain(inputView);
        }
    }

    private void registerLine(InputView inputView) {
        OutputView.printInputRegisterValue(LineText.screenName());
        Line line = new Line(inputView.getInputRegisterLine());
        LineRepository.addLine(line);
        OutputView.printRegisterSuccess();
        goBackToMain(inputView);
    }

    private void deleteLine(InputView inputView) {

    }

    private void lookUpLine(InputView inputView) {

    }

    private void goBackToMain(InputView inputView) {

    }

    public String getControllerIndex() {
        return CONTROLLER_INDEX;
    }
}
