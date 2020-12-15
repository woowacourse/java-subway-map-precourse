package subway.controller;

import subway.domain.SectionRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.FunctionCode;
import subway.view.resource.Message;
import subway.view.resource.Screen;


public class SectionController {
    private SectionController() {

    }

    public static void run() {
        OutputView.printTitle(Screen.SECTION.getTitle());
        OutputView.printFunctionList(Screen.SECTION.getFunctionList());
        callFunction(InputView.getInputFunctionIndex(Screen.SECTION.getIndexList()));
    }

    private static void callFunction(String functionIndex) {
        if (functionIndex.equals(FunctionCode.REGISTER.getIndex())) {
            registerSection();
        }
        if (functionIndex.equals(FunctionCode.DELETE.getIndex())) {
            deleteSection();
        }
        if (functionIndex.equals(FunctionCode.BACK.getIndex())) {
            goBackToMain();
        }
    }

    private static void registerSection() {
        String line = InputView.getInputRegisterLineInSection();
        String station = InputView.getInputRegisterFirstStation(line);
        int index = InputView.getInputIndex(SectionRepository.getLengthByLineName(line));
        SectionRepository.insertSection(line, station, index);
        OutputView.printResultMessage(Message.REGISTER_SECTION_SUCCESS);
        goBackToMain();
    }

    private static void deleteSection() {
        String line = InputView.getInputLineOfDeleteSection();
        String station = InputView.getInputStationOfDeleteSection();
        if (SectionRepository.deleteSection(line, station)) {
            OutputView.printResultMessage(Message.DELETE_SECTION_SUCCESS);
        }
        goBackToMain();
    }

    private static void goBackToMain() {
        MainController.run();
    }
}
