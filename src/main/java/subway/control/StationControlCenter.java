package subway.control;

import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.enums.MainMenu;
import subway.enums.StationMenu;
import subway.view.LineView;
import subway.view.MainView;
import subway.view.StationView;

import java.util.Arrays;
import java.util.Scanner;

public class StationControlCenter {

    public String startStationControl(Scanner scanner) {
        StationView.printStationMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);
        String menu = selectStationMenu(command, scanner);
        if (isUnableCommand(menu)) {
            StationView.informNoMenu();
            return startStationControl(scanner);
        }
        return MainMenu.STATION_CONTROL.getCommand();
    }

    private String selectStationMenu(String command, Scanner scanner) {
        if (command.equals(StationMenu.REGISTER.getCommand()))
            return registerStation(scanner);
        if (command.equals(StationMenu.DELETE.getCommand()))
            return removeStation(scanner);
        if (command.equals(StationMenu.LIST.getCommand()))
            return StationView.printStationList();
        if (command.equalsIgnoreCase(StationMenu.BACK.getCommand()))
            return StationMenu.BACK.getCommand();
        return "";
    }

    private String registerStation(Scanner scanner) {
        String nameOfStationToRegister = inputNameOfStationToRegister(scanner);
        Station stationToRegister = new Station(nameOfStationToRegister);
        StationRepository.addStation(stationToRegister);
        StationView.informStationRegistered();
        return StationMenu.REGISTER.getCommand();
    }

    private String inputNameOfStationToRegister(Scanner scanner) {
        StationView.printAskStationNameToRegister();
        String nameOfStation = MainControlCenter.inputCommand(scanner);
        if (!isValidNameToRegister(nameOfStation)) {
            return inputNameOfStationToRegister(scanner);
        }
        return nameOfStation;
    }

    private boolean isValidNameToRegister(String nameOfStation) {
        if (StationRepository.isNameDuplication(nameOfStation)) {
            StationView.informStationDuplicated();
            return false;
        }
        if (StationRepository.isNameLengthUnderCriteria(nameOfStation)) {
            StationView.informNameLengthUnder2();
            return false;
        }
        if (LineRepository.isNameDuplication(nameOfStation)) {
            LineView.informLineDuplicated();
            return false;
        }
        return true;
    }

    private String removeStation(Scanner scanner) {
        StationView.printAskStationNameToDelete();
        String nameOfStationToDelete = MainControlCenter.inputCommand(scanner);
        if (!isValidNameToDelete(nameOfStationToDelete)) {
            return removeStation(scanner);
        }
        StationRepository.deleteStation(nameOfStationToDelete);
        StationView.informStationDeleted();
        return StationMenu.DELETE.getCommand();
    }

    private boolean isValidNameToDelete(String nameOfStation) {
        if (!StationRepository.isNameDuplication(nameOfStation)) {
            StationView.informStationNotExist();
            return false;
        }
        if (SectionRepository.isStationInSections(nameOfStation)) {
            StationView.informStationOnLine();
            return false;
        }
        return true;
    }

    private boolean isUnableCommand(String menu) {
        return Arrays.stream(StationMenu.values())
                .skip(StationMenu.REGISTER.ordinal())
                .map(StationMenu::getCommand)
                .noneMatch(command -> command.equals(menu));
    }
}
