package subway.control;

import subway.domain.*;
import subway.enums.MainMenu;
import subway.enums.SectionMenu;
import subway.view.LineView;
import subway.view.MainView;
import subway.view.SectionView;
import subway.view.StationView;

import java.util.Arrays;
import java.util.Scanner;

public class SectionControlCenter {

    public SectionControlCenter() {

    }

    public String startSectionControl(Scanner scanner) {
        SectionView.printSectionMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);
        String menu = selectMenu(command, scanner);
        if (isUnableCommand(menu)) {
            SectionView.informNoMenu();
            return startSectionControl(scanner);
        }
        return MainMenu.SECTION_CONTROL.getCommand();
    }

    private String selectMenu(String command, Scanner scanner) {
        if (command.equals(SectionMenu.ENROLL.getCommand()))
            return enrollSection(scanner);
        if (command.equals(SectionMenu.DELETE.getCommand()))
            return deleteStationFromLine(scanner);
        if (command.equalsIgnoreCase(SectionMenu.BACK.getCommand()))
            return SectionMenu.BACK.getCommand();
        return "";
    }

    private String enrollSection(Scanner scanner) {
        Line lineToEnrollStationOn = inputNameOfLine(scanner);
        Station stationToEnrollOnLine = inputNameOfStation(lineToEnrollStationOn, scanner);
        int positionToEnrollStationOnLine = inputPositionToEnrollStation(scanner);
        SectionRepository.addStationOnLine(
                lineToEnrollStationOn, stationToEnrollOnLine, positionToEnrollStationOnLine);
        SectionView.informSectionEnrolled();
        return SectionMenu.ENROLL.getCommand();
    }

    private Line inputNameOfLine(Scanner scanner) {
        SectionView.printAskLineToEnrollStationOn();
        String lineToEnrollStationOn = MainControlCenter.inputCommand(scanner);
        if (!LineRepository.isNameDuplication(lineToEnrollStationOn)) {
            LineView.informLineNotExist();
            return inputNameOfLine(scanner);
        }
        return LineRepository.getLineByName(lineToEnrollStationOn);
    }

    private Station inputNameOfStation(Line lineToEnrollStationOn, Scanner scanner) {
        SectionView.printAskStationToEnrollOnLine();
        String stationToEnrollOnLine = MainControlCenter.inputCommand(scanner);
        if (!StationRepository.isNameDuplication(stationToEnrollOnLine)) {
            StationView.informStationNotExist();
            return inputNameOfStation(lineToEnrollStationOn, scanner);
        }
        if (SectionRepository.isStationOnLine(lineToEnrollStationOn, stationToEnrollOnLine)) {
            StationView.informStationDuplicated();
            return inputNameOfStation(lineToEnrollStationOn, scanner);
        }
        return StationRepository.getStationByName(stationToEnrollOnLine);
    }

    private int inputPositionToEnrollStation(Scanner scanner) {
        SectionView.printAskPosionToEnrollStation();
        String positionToEnrollStation = MainControlCenter.inputCommand(scanner);
        try {
            return Integer.parseInt(positionToEnrollStation);
        } catch (NumberFormatException nfe) {
            SectionView.informNotNumberFormat();
            return inputPositionToEnrollStation(scanner);
        }
    }

    private String deleteStationFromLine(Scanner scanner) {
        Line lineToDeleteStationFrom = inputLineToDeleteStationFrom(scanner);
        Station stationToDeleteFromLine =
                inputStationToDeleteFromLine(lineToDeleteStationFrom, scanner);
        SectionRepository.deleteStationOnLine(lineToDeleteStationFrom, stationToDeleteFromLine);
        SectionView.informSectionDeleted();
        return SectionMenu.DELETE.getCommand();
    }

    private Line inputLineToDeleteStationFrom(Scanner scanner) {
        SectionView.printAskLineToDeleteStationFrom();
        String nameOfLine = MainControlCenter.inputCommand(scanner);
        if (!SectionRepository.isLineOnSectionDuplicated(nameOfLine)) {
            LineView.informLineNotExist();
            return inputLineToDeleteStationFrom(scanner);
        }
        if (SectionRepository.isStationUnder2onLine(nameOfLine)) {
            SectionView.informStationUnder2onLine();
            return inputLineToDeleteStationFrom(scanner);
        }
        return SectionRepository.getSectionByLineName(nameOfLine).getLine();
    }

    private Station inputStationToDeleteFromLine(Line lineToDeleteStationFrom, Scanner scanner) {
        SectionView.printAskStationToDeleteFromLine();
        String nameOfStation = MainControlCenter.inputCommand(scanner);
        if (!SectionRepository.isStationOnLine(lineToDeleteStationFrom, nameOfStation)) {
            StationView.informStationNotExist();
            return inputStationToDeleteFromLine(lineToDeleteStationFrom, scanner);
        }
        return SectionRepository.getStationByName(lineToDeleteStationFrom, nameOfStation);
    }

    private boolean isUnableCommand(String menu) {
        return Arrays.stream(SectionMenu.values())
                .skip(SectionMenu.ENROLL.ordinal())
                .map(SectionMenu::getCommand)
                .noneMatch(command -> command.equals(menu));
    }
}
