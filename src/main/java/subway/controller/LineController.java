package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.Function;
import subway.view.resource.Message;
import subway.view.resource.Screen;

public class LineController {
    private LineController() {

    }

    public static void run() {
        OutputView.printTitle(Screen.LINE.getTitle());
        OutputView.printFunctionList(Screen.LINE.getFunctionList());
        callFunction(InputView.getInputFunctionIndex(Screen.LINE.getIndexList()));
    }

    private static void callFunction(String functionIndex) {
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

    private static void registerLine() {
        Line line = new Line(InputView.getInputRegisterLine());
        LineRepository.addLine(line);
        registerSection(line);
        OutputView.printResultMessage(Message.REGISTER_LINE_SUCCESS);
        goBackToMain();
    }

    private static void deleteLine() {
        String deleteName = InputView.getInputDeleteLine();
        if (LineRepository.deleteLineByName(deleteName)) {
            OutputView.printResultMessage(Message.DELETE_LINE_SUCCESS);
        }
        goBackToMain();
    }

    private static void lookUpLine() {
        OutputView.printListTitle(Screen.LINE.getName());
        for (Line line : LineRepository.lines()) {
            System.out.println(line);
        }
        goBackToMain();
    }

    private static void goBackToMain() {
        MainController.run();
    }

    private static void registerSection(Line line) {
        String firstStation = InputView.getInputRegisterFirstStation(line.getName());
        String lastStation = InputView.getInputRegisterLastStation(firstStation, line.getName());
        SectionRepository.addSection(line.getName(), firstStation, lastStation);
    }
}


