package contants;

import subway.controllers.MainController;
import subway.controllers.SectionMenu;
import subway.domain.*;
import view.InputView;
import view.OutputView;

public class SectionController {
    public static void run() {
        OutputView.printSectionMenu(SectionMenu.getWholeMenu());
        selectMenu();
    }

    private static void selectMenu() {
        OutputView.printSelectFunction();
        try {
            runMenu(InputView.selectFunction());
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

    private static Station getAddingStation() {
        OutputView.print(SectionMenu.getAddingStationName());
        String addingStation = InputView.read();
        return getStation(addingStation);
    }

    private static Line getAddingLine() {
        OutputView.print(SectionMenu.getAddingLineName());
        String addingLineName = InputView.read();
        return LineRepository.get(addingLineName);
    }

    private static void deleteSection() {
        OutputView.printAskDeleteSectionMessage();
        Line line = getDeletingLine();
        Station station = getDeletingStation();
        SectionRepository.deleteSection(line, station);
        OutputView.finishedDeletingSection();
    }

    private static Line getDeletingLine() {
        OutputView.print(SectionMenu.getDeletingLineName());
        String deletingLineName = InputView.read();
        validateStationForSectionDeletion(deletingLineName);
        return getLine(deletingLineName);
    }

    private static Station getDeletingStation() {
        OutputView.print(SectionMenu.getDeletingStationName());
        String stationName = InputView.read();
        validateLineForSectionDeletion(stationName);
        return getStation(stationName);
    }

    private static int getOrder() {
        OutputView.print(SectionMenu.getAddingOrder());
        String order = InputView.read();
        validateSectionSize(order);
        return Integer.valueOf(order);
    }

    private static Line getLine(String lineName) {
        if (!LineRepository.has(lineName)) {
            LineRepository.addLine(LineMaker.make(lineName));
        }
        return LineRepository.get(lineName);
    }

    private static Station getStation(String stationName) {
        if (!StationRepository.has(stationName)) {
            Station station = StationMaker.make(stationName);
            StationRepository.addStation(station);
            return station;
        }
        return StationRepository.get(stationName);
    }

    private static void validateSectionSize(String lineName) {
        if (!SectionRepository.isSectionDeletable(LineRepository.get(lineName))) {
            throw new IllegalArgumentException(ExceptionMessage.SECTION_HAS_LESS_THAN_TWO_STATIONS.toString());
        }
    }

    private static void validateStationForSectionDeletion(String stationName) {
        if (!StationRepository.has(stationName) || !SectionRepository.has(StationRepository.get(stationName))) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_DOES_NOT_EXIST_IN_SECTION.toString());
        }
    }

    private static void validateLineForSectionDeletion(String lineName) {
        if (!LineRepository.has(lineName) || !SectionRepository.has(LineRepository.get(lineName))) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_DOES_NOT_EXIST_IN_SECTION.toString());
        }
    }
}
