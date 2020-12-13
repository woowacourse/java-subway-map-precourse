package subway.controller;

import subway.domain.SectionRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.LineText;
import subway.view.text.SectionText;
import subway.view.text.StationText;

public class SectionController {
    private static String CONTROLLER_INDEX = "3";
    private static String RESISTER_INDEX = "1";
    private static String DELETE_INDEX = "2";

    public void run(InputView inputView) {
        OutputView.printFunctionTitle(SectionText.functionTitle());
        OutputView.printFunctionList(SectionText.functionList());
        OutputView.printInputFunctionIndex();
        callFunction(inputView, inputView.getInputFunctionIndex(SectionText.functionIndexList()));
    }

    private void callFunction(InputView inputView, String functionIndex) {
        if (functionIndex.equals(RESISTER_INDEX)) {
            registerSection(inputView);
        }
        if (functionIndex.equals(DELETE_INDEX)) {
            deleteSection();
        }
        if (functionIndex.equals(MainController.getControllerIndex())) {
            goBackToMain(inputView);
        }
    }

    private void registerSection(InputView inputView) {
        OutputView.printInputValue(LineText.screenName());
        String line = inputView.getInputDeleteLine();
        OutputView.printInputValue(StationText.screenName());
        String station = inputView.getInputRegisterStationForSection();
        OutputView.printInputIndex();
        int index = inputView.getInputIndex(SectionRepository.getLengthByLineName(line));
        SectionRepository.insertSection(line, station, index);
        OutputView.printRegisterSuccess(SectionText.screenName());
        goBackToMain(inputView);
    }

    private void deleteSection() {

    }

    private void goBackToMain(InputView inputView) {
        MainController.run(inputView);
    }

    public static String getControllerIndex() {
        return CONTROLLER_INDEX;
    }
}
