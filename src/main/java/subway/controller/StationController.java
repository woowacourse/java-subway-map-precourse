package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.Screen;
import subway.view.text.StationText;

public class StationController {
    private static String CONTROLLER_INDEX = "1";
    private static String RESISTER_INDEX = "1";
    private static String DELETE_INDEX = "2";
    private static String LOOK_UP_INDEX = "3";

    public void run(InputView inputView) {
        OutputView.printFunctionTitle(StationText.functionTitle());
        OutputView.printFunctionList(StationText.functionList());
        OutputView.printInputFunctionIndex();
        callFunction(inputView, inputView.getInputFunctionIndex(StationText.functionIndexList()));
    }

    private void callFunction(InputView inputView, String functionIndex) {
        if (functionIndex.equals(RESISTER_INDEX)) {
            registerStation(inputView);
        }
        if (functionIndex.equals(DELETE_INDEX)) {
            deleteStation(inputView);
        }
        if (functionIndex.equals(LOOK_UP_INDEX)) {
            lookUpStation(inputView);
        }
        if (functionIndex.equals(MainController.getControllerIndex())) {
            goBackToMain(inputView);
        }
    }

    private void registerStation(InputView inputView) {
        OutputView.printInputRegisterValue(StationText.screenName());
        Station station = new Station(inputView.getInputRegisterStation());
        StationRepository.addStation(station);
        OutputView.printRegisterSuccess(StationText.screenName());
        goBackToMain(inputView);
    }

    private void deleteStation(InputView inputView) {
        OutputView.printInputDeleteValue(Screen.STATION.getTitle());
        if (StationRepository.deleteStation(inputView.getInputDeleteStation())) {
            OutputView.printDeleteSuccess(StationText.screenName());
        }
        goBackToMain(inputView);
    }

    private void lookUpStation(InputView inputView) {
        OutputView.printFunctionTitle(StationText.listTitle());
        for (Station station : StationRepository.stations()) {
            System.out.println(station);
        }
        goBackToMain(inputView);
    }

    private void goBackToMain(InputView inputView) {
        MainController.run(inputView);
    }

    public String getControllerIndex() {
        return CONTROLLER_INDEX;
    }
}
