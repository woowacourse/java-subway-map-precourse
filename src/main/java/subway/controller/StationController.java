package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.Function;
import subway.view.text.Screen;

public class StationController {
    public void run(InputView inputView) {
        OutputView.printTitle(Screen.STATION.getTitle());
        OutputView.printFunctionList(Screen.STATION.getFunctionList());
        OutputView.printInputFunctionIndex();
        callFunction(inputView, inputView.getInputFunctionIndex(Screen.STATION.getIndexList()));
    }

    private void callFunction(InputView inputView, String functionIndex) {
        if (functionIndex.equals(Function.REGISTER.getIndex())) {
            registerStation(inputView);
        }
        if (functionIndex.equals(Function.DELETE.getIndex())) {
            deleteStation(inputView);
        }
        if (functionIndex.equals(Function.LOOKUP.getIndex())) {
            lookUpStation(inputView);
        }
        if (functionIndex.equals(Function.BACK.getIndex())) {
            goBackToMain(inputView);
        }
    }

    private void registerStation(InputView inputView) {
        OutputView.printInputRegisterValue(Screen.STATION.getName());
        Station station = new Station(inputView.getInputRegisterStation());
        StationRepository.addStation(station);
        OutputView.printRegisterSuccess(Screen.STATION.getName());
        goBackToMain(inputView);
    }

    private void deleteStation(InputView inputView) {
        OutputView.printInputDeleteValue(Screen.STATION.getName());
        if (StationRepository.deleteStation(inputView.getInputDeleteStation())) {
            OutputView.printDeleteSuccess(Screen.STATION.getName());
        }
        goBackToMain(inputView);
    }

    private void lookUpStation(InputView inputView) {
        OutputView.printListTitle(Screen.STATION.getName());
        for (Station station : StationRepository.stations()) {
            System.out.println(station);
        }
        goBackToMain(inputView);
    }

    private void goBackToMain(InputView inputView) {
        MainController.run(inputView);
    }
}
