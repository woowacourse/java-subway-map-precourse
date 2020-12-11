package subway.control;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.enums.MainMenu;
import subway.enums.StationMenu;
import subway.view.MainView;
import subway.view.StationView;

import java.util.Scanner;

public class StationControlCenter {

    public StationControlCenter() {

    }

    public String startStationControl(Scanner scanner) {
        StationView.printStationMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);
        selectMenu(command, scanner);
        return MainMenu.STATION_CONTROL.getCommand();
    }

    private void selectMenu(String command, Scanner scanner) {
        if (command.equals(StationMenu.ENROLL.getCommand())) {
            enrollStation(scanner);
            return;
        }
        if (command.equals(StationMenu.DELETE.getCommand())) {
            removeStation(scanner);
            return;
        }
        if (command.equals(StationMenu.CHECK.getCommand())) {
            StationView.printStationList();
            return;
        }
    }

    private void enrollStation(Scanner scanner) {
        String nameOfStation = inputNameOfStation(scanner);
        Station station = new Station(nameOfStation);
        StationRepository.addStation(station);
        StationView.informStationEnrolled();
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

    private void removeStation(Scanner scanner) {
        StationView.printAskStationNameToDelete();
        String nameOfStation = MainControlCenter.inputCommand(scanner);
        if (StationRepository.deleteStation(nameOfStation)) {
            StationView.informStationDeleted();
            return;
        }
        StationView.informStationNotExist();
        removeStation(scanner);
    }
}
