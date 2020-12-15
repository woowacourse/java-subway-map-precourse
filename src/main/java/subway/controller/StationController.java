package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.FunctionCode;
import subway.view.resource.Message;
import subway.view.resource.Screen;

public class StationController {
    private StationController() {

    }

    public static void run() {
        OutputView.printTitle(Screen.STATION.getTitle());
        OutputView.printFunctionList(Screen.STATION.getFunctionList());
        callFunction(InputView.getInputFunctionIndex(Screen.STATION.getIndexList()));
    }

    private static void callFunction(String functionIndex) {
        if (functionIndex.equals(FunctionCode.REGISTER.getIndex())) {
            registerStation();
        }
        if (functionIndex.equals(FunctionCode.DELETE.getIndex())) {
            deleteStation();
        }
        if (functionIndex.equals(FunctionCode.LOOKUP.getIndex())) {
            lookUpStation();
        }
        if (functionIndex.equals(FunctionCode.BACK.getIndex())) {
            goBackToMain();
        }
    }

    private static void registerStation() {
        Station station = new Station(InputView.getInputRegisterStation());
        StationRepository.addStation(station);
        OutputView.printResultMessage(Message.REGISTER_STATION_SUCCESS);
        goBackToMain();
    }

    private static void deleteStation() {
        if (StationRepository.deleteStation(InputView.getInputDeleteStation())) {
            OutputView.printResultMessage(Message.DELETE_STATION_SUCCESS);
        }
        goBackToMain();
    }

    private static void lookUpStation() {
        OutputView.printListTitle(Screen.STATION.getName());
        for (Station station : StationRepository.stations()) {
            System.out.println(station);
        }
        goBackToMain();
    }

    private static void goBackToMain() {
        MainController.run();
    }
}
