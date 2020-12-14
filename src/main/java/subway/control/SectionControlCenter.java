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

    public String startSectionControl(Scanner scanner) {
        SectionView.printSectionMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);
        String menu = selectSectionMenu(command, scanner);
        if (isUnableCommand(menu)) {
            SectionView.informNoMenu();
            return startSectionControl(scanner);
        }
        return MainMenu.SECTION_CONTROL.getCommand();
    }

    private String selectSectionMenu(String command, Scanner scanner) {
        if (command.equals(SectionMenu.REGISTER.getCommand()))
            return registerSection(scanner);
        if (command.equals(SectionMenu.DELETE.getCommand()))
            return deleteStationFromLine(scanner);
        if (command.equalsIgnoreCase(SectionMenu.BACK.getCommand()))
            return SectionMenu.BACK.getCommand();
        return "";
    }

    private String registerSection(Scanner scanner) {
        Line lineToRegisterStationOn = inputNameOfLineToRegisterStationOn(scanner);
        Station stationToRegisterOnLine =
                inputNameOfStationToRegisterOnLine(lineToRegisterStationOn, scanner);
        int positionToRegisterStationOnLine = inputPositionToRegisterStation(scanner);
        SectionRepository.addStationOnLine(
                lineToRegisterStationOn, stationToRegisterOnLine, positionToRegisterStationOnLine);
        if (SectionRepository.hasTotallySameOrderOfStations(lineToRegisterStationOn)
                || SectionRepository.hasTotallyReverseOrderOfStations(lineToRegisterStationOn)) {
            SectionView.informSameOrReverseOrderOfStations();
            SectionRepository.deleteStationOnLine(
                    lineToRegisterStationOn, stationToRegisterOnLine);
            return SectionMenu.REGISTER.getCommand();
        }
        SectionView.informSectionRegistered();
        return SectionMenu.REGISTER.getCommand();
    }

    private Line inputNameOfLineToRegisterStationOn(Scanner scanner) {
        SectionView.printAskLineToRegisterStationOn();
        String lineToRegisterStationOn = MainControlCenter.inputCommand(scanner);
        if (!LineRepository.isNameDuplication(lineToRegisterStationOn)) {
            LineView.informLineNotExist();
            return inputNameOfLineToRegisterStationOn(scanner);
        }
        return LineRepository.getLineByName(lineToRegisterStationOn);
    }

    private Station inputNameOfStationToRegisterOnLine(
            Line lineToEnrollStationOn, Scanner scanner) {
        SectionView.printAskStationToRegisterOnLine();
        String nameOfStationToRegisterOnLine = MainControlCenter.inputCommand(scanner);
        if (!StationRepository.isNameDuplication(nameOfStationToRegisterOnLine)) {
            StationView.informStationNotExist();
            return inputNameOfStationToRegisterOnLine(lineToEnrollStationOn, scanner);
        }
        if (SectionRepository.isStationOnLine(lineToEnrollStationOn
                , nameOfStationToRegisterOnLine)) {
            StationView.informStationDuplicated();
            return inputNameOfStationToRegisterOnLine(lineToEnrollStationOn, scanner);
        }
        return StationRepository.getStationByName(nameOfStationToRegisterOnLine);
    }

    private int inputPositionToRegisterStation(Scanner scanner) {
        SectionView.printAskPositionToRegisterStation();
        String positionToRegisterStation = MainControlCenter.inputCommand(scanner);
        try {
            return Integer.parseInt(positionToRegisterStation);
        } catch (NumberFormatException nfe) {
            SectionView.informNotNumberFormat();
            return inputPositionToRegisterStation(scanner);
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
        String nameOfLineToDeleteStationFrom = MainControlCenter.inputCommand(scanner);
        if (!SectionRepository.isLineOnSectionDuplicated(nameOfLineToDeleteStationFrom)) {
            LineView.informLineNotExist();
            return inputLineToDeleteStationFrom(scanner);
        }
        if (SectionRepository.isStationUnder2onLine(nameOfLineToDeleteStationFrom)) {
            SectionView.informStationUnder2onLine();
            return inputLineToDeleteStationFrom(scanner);
        }
        return SectionRepository.getSectionByLineName(nameOfLineToDeleteStationFrom).getLine();
    }

    private Station inputStationToDeleteFromLine(Line lineToDeleteStationFrom, Scanner scanner) {
        SectionView.printAskStationToDeleteFromLine();
        String nameOfStationToDeleteFromLine = MainControlCenter.inputCommand(scanner);
        if (!SectionRepository.isStationOnLine(
                lineToDeleteStationFrom, nameOfStationToDeleteFromLine)) {
            StationView.informStationNotExist();
            return inputStationToDeleteFromLine(lineToDeleteStationFrom, scanner);
        }
        return SectionRepository.getStationByLineAndNameOfStation(
                lineToDeleteStationFrom, nameOfStationToDeleteFromLine);
    }

    private boolean isUnableCommand(String menu) {
        return Arrays.stream(SectionMenu.values())
                .skip(SectionMenu.REGISTER.ordinal())
                .map(SectionMenu::getCommand)
                .noneMatch(command -> command.equals(menu));
    }
}
