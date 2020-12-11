package subway.control;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.enums.MainMenu;
import subway.enums.StationMenu;
import subway.view.MainView;
import subway.view.StationView;

import java.util.Arrays;
import java.util.Scanner;

public class StationControlCenter {

    public StationControlCenter() {

    }

    public String startStationControl(Scanner scanner) {
        StationView.printStationMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);
        String menu = selectMenu(command, scanner);
        if (isUnableCommand(menu)) {
            StationView.informNoMenu();
            return startStationControl(scanner);
        }
        return MainMenu.STATION_CONTROL.getCommand();
    }

    private String selectMenu(String command, Scanner scanner) {
        if (command.equals(StationMenu.ENROLL.getCommand()))
            return enrollStation(scanner);
        if (command.equals(StationMenu.DELETE.getCommand()))
            return removeStation(scanner);
        if (command.equals(StationMenu.CHECK.getCommand()))
            return StationView.printStationList();
        if (command.equalsIgnoreCase(StationMenu.BACK.getCommand()))
            return StationMenu.BACK.getCommand();
        return "";
    }

    private String enrollStation(Scanner scanner) {
        String nameOfStation = inputNameOfStation(scanner);
        Station station = new Station(nameOfStation);
        StationRepository.addStation(station);
        StationView.informStationEnrolled();
        return StationMenu.ENROLL.getCommand();
    }

    private String inputNameOfStation(Scanner scanner) {
        StationView.printAskStationNameToEnroll();
        String nameOfStation = MainControlCenter.inputCommand(scanner);
        if (StationRepository.isNameDuplication(nameOfStation)) {
            StationView.infromStationDuplicated();
            return inputNameOfStation(scanner);
        }
        if (StationRepository.isNameLengthUnder2(nameOfStation)) {
            StationView.informNameLengthUnder2();
            return inputNameOfStation(scanner);
        }
        return nameOfStation;
    }

    private String removeStation(Scanner scanner) {
        StationView.printAskStationNameToDelete();
        String nameOfStation = MainControlCenter.inputCommand(scanner);
        if (StationRepository.deleteStation(nameOfStation)) {
            StationView.informStationDeleted();
            return StationMenu.DELETE.getCommand();
        }
        StationView.informStationNotExist();
        return removeStation(scanner);
    }

    private void informNoMenu(String menu) {
        if (isUnableCommand(menu)) {
            MainView.informUnableCommand();
        }
    }

    private boolean isUnableCommand(String menu) {
        return Arrays.stream(StationMenu.values())
                .skip(StationMenu.ENROLL.ordinal())
                .map(StationMenu::getCommand)
                .noneMatch(command -> command.equals(menu));
    }
}
