package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
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
        registerSection(inputView,line);
        OutputView.printRegisterSuccess(LineText.screenName());
        goBackToMain(inputView);
    }

    private void deleteLine(InputView inputView) {
        OutputView.printInputDeleteValue(LineText.screenName());
        if (LineRepository.deleteLineByName(inputView.getInputDeleteLine())){
            OutputView.printDeleteSuccess(LineText.screenName());
        }
        goBackToMain(inputView);
    }

    private void lookUpLine(InputView inputView) {
        OutputView.printFunctionTitle(LineText.listTitle());
        for (Line line : LineRepository.lines()) {
            System.out.println(line.toString());
        }
        goBackToMain(inputView);
    }

    private void goBackToMain(InputView inputView) {
        MainController.run(inputView);
    }

    private void registerSection(InputView inputView, Line line) {
        OutputView.printRegisterFirstStation();
        String firstStation = inputView.getInputRegisterStationForSection();
        OutputView.printRegisterLastStation();
        String lastStation = inputView.getInputRegisterStationForSection(firstStation);
        SectionRepository.addSection(line.getName(), firstStation, lastStation);
    }

    public String getControllerIndex() {
        return CONTROLLER_INDEX;
    }
}


