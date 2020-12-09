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

        StationRepository.stations().stream().map(Station::getName).forEach(System.out::println);
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
    }

    private void enrollStation(Scanner scanner) {
        StationView.printAskStationNameToEnroll();
        String nameOfStation = MainControlCenter.inputCommand(scanner);
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
