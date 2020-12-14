package subway.controller;

import subway.domain.SectionRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.Function;
import subway.view.resource.Screen;


public class SectionController {
    public void run() {
        OutputView.printTitle(Screen.SECTION.getTitle());
        OutputView.printFunctionList(Screen.SECTION.getFunctionList());
        OutputView.printInputFunctionIndex();
        callFunction(InputView.getInputFunctionIndex(Screen.SECTION.getIndexList()));
    }

    private void callFunction(String functionIndex) {
        if (functionIndex.equals(Function.REGISTER.getIndex())) {
            registerSection();
        }
        if (functionIndex.equals(Function.DELETE.getIndex())) {
            deleteSection();
        }
        if (functionIndex.equals(Function.BACK.getIndex())) {
            goBackToMain();
        }
    }

    private void registerSection() {
        OutputView.printInputValue(Screen.LINE.getName());
        String line = InputView.getInputDeleteLine();
        OutputView.printInputValue(Screen.STATION.getName());
        String station = InputView.getInputRegisterFirstStation(line);
        OutputView.printInputIndex();
        int index = InputView.getInputIndex(SectionRepository.getLengthByLineName(line));
        SectionRepository.insertSection(line, station, index);
        OutputView.printRegisterSuccess(Screen.SECTION.getName());
        goBackToMain();
    }

    private void deleteSection() {
        OutputView.printInputValueOfDeleteSection(Screen.LINE.getName());
        String line = InputView.getInputLineOfDeleteSection();
        OutputView.printInputValueOfDeleteSection(Screen.STATION.getName());
        String station = InputView.getInputStationOfDeleteSection();
        if (SectionRepository.deleteSection(line, station)) {
            OutputView.printDeleteSuccess(Screen.SECTION.getName());
        }
        goBackToMain();
    }

    private void goBackToMain() {
        MainController.run();
    }
}
