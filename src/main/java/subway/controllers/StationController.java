package subway.controllers;

import contants.ExceptionMessage;
import contants.StationMenu;
import subway.domain.SectionRepository;
import subway.domain.Station;
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
            addStation();
        }
        if (StationMenu.SECOND.getUserInput().equals(selection)) {
            deleteStation();
        }
        if (StationMenu.THIRD.getUserInput().equals(selection)) {
            printStations();
        }
        if (StationMenu.BACK.getUserInput().equals(selection)) {
            goBackToMain();
        }
    }

    private static void goBackToMain() {
        MainController.run();
    }

    private static void printStations() {
        OutputView.printLookupStations(StationRepository.stations().stream()
                .map(station -> station.getName()).collect(Collectors.toList())
        );
    }

    private static void deleteStation() {
        OutputView.printAskDeleteStation();
        String stationName = InputView.readDeletingStationName();
        stationDeleteValidation(stationName);
        StationRepository.deleteStation(stationName);
    }

    private static void addStation() {
        // TODO : add에 대한 중복 검사는 아이디로 진행되고 있음
        OutputView.printAskAddStation();
        String stationName = InputView.readStationName();
        validateDuplication(stationName);
        StationRepository.addStation(StationMaker.make(stationName));
        OutputView.printFinishedAddingStation();
    }

    private static void validateDuplication(String stationName) {
        if (StationRepository.has(stationName)) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_DUPLICATION.toString());
        }
    }

    private static void stationDeleteValidation(String stationName) {
        validateDoesNotExist(stationName);
        // TODO: 역 삭제 시 등록된 노선에 대한 체크
        validateSectionRegistered(stationName);
    }

    private static void validateSectionRegistered(String stationName) {
        if (StationRepository.has(stationName) && SectionRepository.has(StationRepository.get(stationName))) {
            throw new IllegalArgumentException(ExceptionMessage.ALREADY_REGISTERED_TO_SECTION.toString());
        }
    }

    private static void validateDoesNotExist(String stationName) {
        if (!StationRepository.has(stationName)) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_NOT_EXISTS.toString());
        }
    }
}
