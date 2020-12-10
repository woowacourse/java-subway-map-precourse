package subway.control;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.enums.StationMenu;
import subway.view.MainView;
import subway.view.StationView;

import java.util.Scanner;

public class StationControlCenter {

    public StationControlCenter() {

    }

    public void startStationControl(Scanner scanner) {
        StationView.printStationMenu();
        MainView.askInputMenu();
        String command = MainControlCenter.inputCommand(scanner);
        selectMenu(command, scanner);
    }

    private void selectMenu(String command, Scanner scanner) {
        if (command.equals(StationMenu.ENROLL.getCommand())) {
            enrollStation(scanner);
            return;
        }
        if (command.equals(StationMenu.DELETE.getCommand())) {
            deleteStation(scanner);
            return;
        }
        if (command.equals(StationMenu.CHECK.getCommand())) {
            StationView.printStationList();
            return;
        }
    }

    private void enrollStation(Scanner scanner) {
        StationView.printAskStationNameToEnroll();
        String nameOfStation = MainControlCenter.inputCommand(scanner);
        if (StationRepository.isNameDuplication(nameOfStation)) {
            StationView.infromStationDuplicated();
            enrollStation(scanner);
            return;
        }
        if (StationRepository.isNameLengthUnder2(nameOfStation)) {
            StationView.informNameLengthUnder2();
            enrollStation(scanner);
            return;
        }
        Station station = new Station(nameOfStation);
        StationRepository.addStation(station);
        StationView.informStationEnrolled();
    }

    private void deleteStation(Scanner scanner) {
        StationView.printAskStationNameToDelete();
        String nameOfStation = MainControlCenter.inputCommand(scanner);
        StationRepository.deleteStation(nameOfStation);
        StationView.informStationDeleted();
    }
}
