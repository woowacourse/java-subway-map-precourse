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
            addStation();
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

    private void addStation() {
        System.out.println("\n## 등록할 역 이름을 입력하세요");
        String station = askStationName();
        if (isDuplicate(station)) {
            System.out.println("\n[ERROR] 이미 등록된 역입니다.");
            run();
        }
        StationRepository.addStation(new Station(station));
    }

    private boolean isDuplicate(String station) {
        return StationRepository.hasStation(station);

    }


    public String askStationName() {
        String userInput = scanner.nextLine();
        //Todo validate userInput
        return userInput;
    }

}
