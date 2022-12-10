package subway.controllers;

import contants.ExceptionMessage;
import contants.MainMenu;
import contants.StationMenu;
import subway.domain.Station;
import subway.domain.StationMaker;
import subway.domain.StationRepository;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class StationController {
    public static void run(Scanner scanner) {
        OutputView.printStationMenu(StationMenu.getWholeMenu());
        selectMenu(scanner);
    }

    private static void selectMenu(Scanner scanner) {
        OutputView.printSelectFunction();
        String selection = InputView.selectFunction(scanner);
        if (StationMenu.FIRST.getUserInput().equals(selection)) {
            // TODO : add에 대한 중복 검사는 아이디로 진행되고 있음
            OutputView.printAskAddStation();
            StationRepository.addStation(StationMaker.make(InputView.readStationName(scanner)));
            OutputView.printFinishedAddingStation();
        }
        if (StationMenu.SECOND.getUserInput().equals(selection)) {
            OutputView.printAskAddStation();
            String stationName = InputView.readDeletingStationName(scanner);
            stationDeleteValidation(stationName);
            StationRepository.deleteStation(stationName);
        }
        if (StationMenu.THIRD.getUserInput().equals(selection)) {

        }
        if (StationMenu.BACK.getUserInput().equals(selection)) {

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
