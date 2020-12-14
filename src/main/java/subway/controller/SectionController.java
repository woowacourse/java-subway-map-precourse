package subway.controller;

import subway.domain.SectionRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.Function;
import subway.view.text.Screen;


public class SectionController {
    public void run(InputView inputView) {
        OutputView.printTitle(Screen.SECTION.getTitle());
        OutputView.printFunctionList(Screen.SECTION.getFunctionList());
        OutputView.printInputFunctionIndex();
        callFunction(inputView, inputView.getInputFunctionIndex(Screen.SECTION.getIndexList()));
    }

    private void callFunction(InputView inputView, String functionIndex) {
        if (functionIndex.equals(Function.REGISTER.getIndex())) {
            registerSection(inputView);
        }
        if (functionIndex.equals(Function.DELETE.getIndex())) {
            deleteSection(inputView);
        }
        if (functionIndex.equals(Function.BACK.getIndex())) {
            goBackToMain(inputView);
        }
    }

    private void registerSection(InputView inputView) {
        OutputView.printInputValue(Screen.LINE.getName());
        String line = inputView.getInputDeleteLine();
        OutputView.printInputValue(Screen.STATION.getName());
        String station = inputView.getInputRegisterFirstStation(line);
        OutputView.printInputIndex();
        int index = inputView.getInputIndex(SectionRepository.getLengthByLineName(line));
        SectionRepository.insertSection(line, station, index);
        OutputView.printRegisterSuccess(Screen.SECTION.getName());
        goBackToMain(inputView);
    }

    private void deleteSection(InputView inputView) {
        OutputView.printInputValueOfDeleteSection(Screen.LINE.getName());
        String line = inputView.getInputLineOfDeleteSection();
        OutputView.printInputValueOfDeleteSection(Screen.STATION.getName());
        String station = inputView.getInputStationOfDeleteSection();
        if (SectionRepository.deleteSection(line, station)) {
            OutputView.printDeleteSuccess(Screen.SECTION.getName());
        }
        goBackToMain(inputView);
    }

    private void goBackToMain(InputView inputView) {
        MainController.run(inputView);
    }
}
