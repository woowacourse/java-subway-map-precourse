package subway.controllers;

import constants.ExceptionMessage;
import constants.StationMenu;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationMaker;
import subway.domain.StationRepository;
import view.InputView;
import view.OutputView;

import java.util.stream.Collectors;

public class StationController {
    public static void run() {
        selectMenu();
    }

    private static void selectMenu() {
        try {
            select(InputView.selectStationMenu());
        } catch (IllegalArgumentException exception) {
            OutputView.print(exception.getMessage());
            run();
        }
    }

    private static void select(String selection) {
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
                .map(Station::getName).collect(Collectors.toList())
        );
    }

    private static void deleteStation() {
        String stationName = InputView.readDeletingStationName();
        stationDeleteValidation(stationName);
        StationRepository.deleteStation(stationName);
    }

    private static void addStation() {
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
        validateSectionRegistered(stationName);
    }

    private static void validateSectionRegistered(String stationName) {
        if (SectionRepository.has(StationRepository.get(stationName))) {
            throw new IllegalArgumentException(ExceptionMessage.ALREADY_REGISTERED_TO_SECTION.toString());
        }
    }

    private static void validateDoesNotExist(String stationName) {
        if (!StationRepository.has(stationName)) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_NOT_EXISTS.toString());
        }
    }
}
