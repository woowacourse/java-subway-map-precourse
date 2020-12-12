package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class StationManager {
    private final Scanner scanner;

    public StationManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        InputView inputView = new InputView(scanner, "stationManager");
        String menuNumber = inputView.nextMenu();
        selectMenu(menuNumber);
    }

    public void selectMenu(String menuNumber) {
        if (menuNumber.equals("1")) {
            String station = askStationName();
            StationRepository.addStation(new Station(station));
        } else if (menuNumber.equals("2")) {
            String station = askStationName();
            StationRepository.deleteStation(station);
        }
//        else if (stationMenuNumber == 3) {
//
//        } else if (stationMenuNumber == 0) {
//
//        }
    }

    public String askStationName() {
        String userInput = scanner.nextLine();
        //Todo validate userInput
        return userInput;
    }

}
