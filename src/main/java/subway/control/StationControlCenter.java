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
    }

    private void enrollStation(Scanner scanner) {
        StationView.printAskStationName();
        String nameOfStation = MainControlCenter.inputCommand(scanner);
        Station station = new Station(nameOfStation);
        StationRepository.addStation(station);
        StationView.informStationEnrolled();
    }
}
