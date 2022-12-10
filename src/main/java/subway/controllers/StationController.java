package subway.controllers;

import contants.ExceptionMessage;
import contants.StationMenu;
import subway.domain.StationMaker;
import subway.domain.StationRepository;
import view.InputView;
import view.OutputView;

import java.util.Scanner;
import java.util.stream.Collectors;

public class StationController {
    public static void run() {
        OutputView.printStationMenu(StationMenu.getWholeMenu());
        selectMenu();
    }

    private static void selectMenu() {
        OutputView.printSelectFunction();
        String selection = InputView.selectFunction();
        if (StationMenu.FIRST.getUserInput().equals(selection)) {
            // TODO : add에 대한 중복 검사는 아이디로 진행되고 있음
            OutputView.printAskAddStation();
            StationRepository.addStation(StationMaker.make(InputView.readStationName()));
            OutputView.printFinishedAddingStation();
        }
        if (StationMenu.SECOND.getUserInput().equals(selection)) {
            OutputView.printAskAddStation();
            String stationName = InputView.readDeletingStationName();
            stationDeleteValidation(stationName);
            StationRepository.deleteStation(stationName);
        }
        if (StationMenu.THIRD.getUserInput().equals(selection)) {
            OutputView.printLookupStations(StationRepository.stations().stream()
                    .map(station -> station.getName()).collect(Collectors.toList())
            );
        }
        if (StationMenu.BACK.getUserInput().equals(selection)) {
            MainController.run();
        }
    }

    private static void stationDeleteValidation(String stationName) {
        validateDoesNotExist(stationName);
        // TODO: 역 삭제 시 등록된 노선에 대한 체크
//        validateSectionRegistered(stationName);
    }

    private static void validateDoesNotExist(String stationName) {
        if (!StationRepository.has(stationName)) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_NOT_EXISTS.toString());
        }
    }
}
