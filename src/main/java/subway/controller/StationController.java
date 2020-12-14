package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.Function;
import subway.view.resource.Screen;

public class StationController {
    public void run() {
        OutputView.printTitle(Screen.STATION.getTitle());
        OutputView.printFunctionList(Screen.STATION.getFunctionList());
        OutputView.printInputFunctionIndex();
        callFunction(InputView.getInputFunctionIndex(Screen.STATION.getIndexList()));
    }

    private void callFunction(String functionIndex) {
        if (functionIndex.equals(Function.REGISTER.getIndex())) {
            registerStation();
        }
        if (functionIndex.equals(Function.DELETE.getIndex())) {
            deleteStation();
        }
        if (functionIndex.equals(Function.LOOKUP.getIndex())) {
            lookUpStation();
        }
        if (functionIndex.equals(Function.BACK.getIndex())) {
            goBackToMain();
        }
    }

    private void registerStation() {
        OutputView.printInputRegisterValue(Screen.STATION.getName());
        Station station = new Station(InputView.getInputRegisterStation());
        StationRepository.addStation(station);
        OutputView.printRegisterSuccess(Screen.STATION.getName());
        goBackToMain();
    }

    private void deleteStation() {
        OutputView.printInputDeleteValue(Screen.STATION.getName());
        if (StationRepository.deleteStation(InputView.getInputDeleteStation())) {
            OutputView.printDeleteSuccess(Screen.STATION.getName());
        }
        goBackToMain();
    }

    private void lookUpStation() {
        OutputView.printListTitle(Screen.STATION.getName());
        for (Station station : StationRepository.stations()) {
            System.out.println(station);
        }
        goBackToMain();
    }

    private void goBackToMain() {
        MainController.run();
    }
}
