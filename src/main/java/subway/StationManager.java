package subway;

import subway.domain.LineRepository;
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
            deleteStation();
        } else if (menuNumber.equals("3")) {
            printStation();
        }
    }

    private void addStation() {
        System.out.println("\n## 등록할 역 이름을 입력하세요");
        String station = InputView.askName(scanner);
        try {
            validateOverTwoWords(station);
            validateNotExisting(station);
            StationRepository.addStation(new Station(station));
            System.out.println("[INFO] 지하철 역이 등록되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e + "\n");
        }
    }

    private void validateNotExisting(String station) {
        if (StationRepository.hasStation(station)) {
            throw new IllegalArgumentException("[ERROR] 이미 등록된 역입니다.");
        }
    }

    private void validateOverTwoWords(String station) {
        if (station.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 역 이름을 2글자 이상이어야합니다.");
        }
    }

    //TODO 노선에 등록된 역은 삭제 안되게 하기
    private void deleteStation() {
        System.out.println("\n## 삭제할 역 이름을 입력하세요");
        String station = InputView.askName(scanner);
        try {
            validateExisting(station);
            validateRegisteredToLine(station);
            StationRepository.deleteStation(station);
            System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e + "\n");
            run();
        }
    }

    private void validateExisting(String station) {
        if (!StationRepository.hasStation(station)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
        }
    }

    private void validateRegisteredToLine(String station) {
        if (LineRepository.hasStationInSection(station)) {
            throw new IllegalArgumentException("[ERROR] 노선에 등록되어 있는 역을 지울 수 없습니다.");
        }
    }

    public void printStation() {
        StationRepository.print();
    }


}
