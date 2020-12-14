package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.Function;
import subway.view.resource.Screen;

public class LineController {
    public void run() {
        OutputView.printTitle(Screen.LINE.getTitle());
        OutputView.printFunctionList(Screen.LINE.getFunctionList());
        OutputView.printInputFunctionIndex();
        callFunction(InputView.getInputFunctionIndex(Screen.LINE.getIndexList()));
    }

    private void callFunction(String functionIndex) {
        if (functionIndex.equals(Function.REGISTER.getIndex())) {
            registerLine();
        }
        if (functionIndex.equals(Function.DELETE.getIndex())) {
            deleteLine();
        }
        if (functionIndex.equals(Function.LOOKUP.getIndex())) {
            lookUpLine();
        }
        if (functionIndex.equals(Function.BACK.getIndex())) {
            goBackToMain();
        }
    }

    private void registerLine() {
        OutputView.printInputRegisterValue(Screen.LINE.getName());
        Line line = new Line(InputView.getInputRegisterLine());
        LineRepository.addLine(line);
        registerSection(line);
        OutputView.printRegisterSuccess(Screen.LINE.getName());
        goBackToMain();
    }

    private void deleteLine() {
        OutputView.printInputDeleteValue(Screen.LINE.getName());
        if (LineRepository.deleteLineByName(InputView.getInputDeleteLine())) {
            OutputView.printDeleteSuccess(Screen.LINE.getName());
        }
        goBackToMain();
    }

    private void lookUpLine() {
        OutputView.printListTitle(Screen.LINE.getName());
        for (Line line : LineRepository.lines()) {
            System.out.println(line);
        }
        goBackToMain();
    }

    private void goBackToMain() {
        MainController.run();
    }

    private void registerSection(Line line) {
        OutputView.printRegisterFirstStation();
        String firstStation = InputView.getInputRegisterFirstStation(line.getName());
        OutputView.printRegisterLastStation();
        String lastStation = InputView.getInputRegisterLastStation(firstStation, line.getName());
        SectionRepository.addSection(line.getName(), firstStation, lastStation);
    }
}


