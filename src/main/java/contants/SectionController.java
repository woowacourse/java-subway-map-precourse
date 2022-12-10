package contants;

import subway.controllers.MainController;
import subway.controllers.SectionMenu;
import subway.domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class SectionController {
    public static void run() {
        OutputView.printSectionMenu(SectionMenu.getWholeMenu());
        selectMenu();
    }

    private static void selectMenu() {
        OutputView.printSelectFunction();
        String selection = InputView.selectFunction();
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

    private static void deleteSection() {
        OutputView.printAskDeleteSectionMessage();
        List<String> inputs = new ArrayList<>();
        for (String message : SectionMenu.getDeleteSectionFollowingMessages()) {
            OutputView.print(message);
            inputs.add(InputView.read());
        }
        validateLineForSectionDeletion(inputs.get(0));
        validateStationForSectionDeletion(inputs.get(1));
        validateSectionSize(inputs.get(0));
        OutputView.finishedDeletingSection();
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

    private static void registerSection() {
        List<String> inputs = new ArrayList<>();
        for (String message : SectionMenu.getAddSectionFollowingMessages()) {
            OutputView.print(message);
            inputs.add(InputView.read());
        }
        validateLineOfSection(inputs.get(0));
        // TODO: integer.valueof 바꿥괴
        SectionRepository.addToSection(LineMaker.make(inputs.get(0)), getStation(inputs.get(1)), Integer.valueOf(inputs.get(2)));
        OutputView.printFinishedAddingSection();
    }

    private static Station getStation(String stationName) {
        if (!StationRepository.has(stationName)) {
            Station station = StationMaker.make(stationName);
            StationRepository.addStation(station);
            return station;
        }
        return StationRepository.get(stationName);
    }

    private static void validateLineOfSection(String lineName) {
        // TODO: Exception 클래스 만들면 좋을듯
        if (!LineRepository.has(lineName)) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_DOES_NOT_EXIST.toString());
        }
    }
}
