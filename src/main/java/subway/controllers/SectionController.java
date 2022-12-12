package subway.controllers;

import constants.ExceptionMessage;
import constants.MainMenu;
import subway.domain.*;
import view.InputView;
import view.OutputView;

public class SectionController {
    public static void run() {
        selectMenu();
    }

    private static void selectMenu() {
        try {
            runMenu(InputView.selectSectionMenu());
        } catch (IllegalArgumentException exception) {
            OutputView.print(exception.getMessage());
            run();
        }
    }

    private static void runMenu(String selection) {
        if (SectionMenu.FIRST.getUserInput().equals(selection)) {
            registerSection();
        }
        if (SectionMenu.SECOND.getUserInput().equals(selection)) {
            deleteSection();
        }
        if (SectionMenu.BACK.getUserInput().equals(selection)) {
            MainController.run();
        }
    }

    private static void registerSection() {
        Line line = getAddingLine();
        Station station = getAddingStation();
        int order = getOrder();
        SectionRepository.addToSection(line, station, order);
        OutputView.printFinishedAddingSection();
    }

    private static Line getAddingLine() {
        String addingLineName = InputView.readAddingLine();
        return LineRepository.getLineByName(addingLineName);
    }

    private static Station getAddingStation() {
        String addingStationName = InputView.readAddingStation();
        return getStation(addingStationName);
    }

    private static void deleteSection() {
        Line line = getDeletingLine();
        Station station = getDeletingStation();
        SectionRepository.deleteSection(line, station);
        OutputView.finishedDeletingSection();
    }

    private static Line getDeletingLine() {
        String deletingLineName = InputView.readDeletingLineName();
        validateLineForSectionDeletion(deletingLineName);
        validateSectionSize(deletingLineName);
        return getLine(deletingLineName);
    }

    private static Station getDeletingStation() {
        String stationName = InputView.readDeletingStationNameInSection();
        return getStation(stationName);
    }

    private static Station getStation(String stationName) {
        if (!StationRepository.has(stationName)) {
            StationRepository.addStation(StationMaker.make(stationName));
        }
        return StationRepository.get(stationName);
    }

    private static void validateLineForSectionDeletion(String lineName) {
        if (!LineRepository.has(lineName) || !SectionRepository.has(LineRepository.getLineByName(lineName))) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_DOES_NOT_EXIST_IN_SECTION.toString());
        }
    }

    private static int getOrder() {
        String order = InputView.readOrder();
        validateAddingOrder(order);
        return Integer.valueOf(order);
    }

    private static void validateAddingOrder(String order) {
        validateNumericOnly(order);
    }

    private static final String regex = "[0-9]+";

    private static void validateNumericOnly(String bridgeSize) {
        if (!bridgeSize.matches(regex)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private static Line getLine(String lineName) {
        if (!LineRepository.has(lineName)) {
            LineRepository.addLine(LineMaker.make(lineName));
        }
        return LineRepository.getLineByName(lineName);
    }

    private static void validateSectionSize(String lineName) {
        if (!SectionRepository.isSectionDeletable(LineRepository.getLineByName(lineName))) {
            throw new IllegalArgumentException(ExceptionMessage.SECTION_HAS_LESS_THAN_TWO_STATIONS.toString());
        }
    }
}
