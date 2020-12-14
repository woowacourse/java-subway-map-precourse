package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Scanner;

public class SectionManager {
    private final Scanner scanner;

    public SectionManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        InputView inputView = new InputView(scanner, "sectionManager");
        String menuNumber = inputView.nextMenu();
        selectMenu(menuNumber);
    }

    private void selectMenu(String menuNumber) {
        if (menuNumber.equals("1")) {
            addStationToLine();
        } else if (menuNumber.equals("2")) {
            deleteLine();
        }
    }

    private void addStationToLine() {
        System.out.println("\n## 노선을 입력하세요.");
        String line = InputView.askName(scanner);
        System.out.println("\n## 역이름을 입력하세요.");
        String station = InputView.askName(scanner);
        System.out.println("\n## 순서를 입력하세요.");
        String index = InputView.askName(scanner);
        try {
            validateExistingLine(line);
            validateExistingStation(station);
            LineRepository.searchLineByName(line).addStationToSection(Integer.parseInt(index) - 1, station);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            run();
        }
    }

    private void validateExistingLine(String line) {
        if (!LineRepository.hasLine(line)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 노선입니다.");
        }
    }

    private void validateExistingStation(String station) {
        if (!StationRepository.hasStation(station)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
        }
    }

    private void deleteLine() {
        System.out.println("\n## 노선을 입력하세요.");
        String line = InputView.askName(scanner);
        System.out.println("\n## 삭제할 구간의 역을 입력하세요.");
        String station = InputView.askName(scanner);
        try {
            validateExistingLine(line);
            validateLineHasLeastTwoStation(line);
            if (!LineRepository.searchLineByName(line).deleteStationFromSection(station)) {
                throw new IllegalArgumentException("\n[ERROR] 노선에 존재하지 않는 역입니다.");
            }
            System.out.println("\n[INFO] 구간이 삭제되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            run();
        }
    }

    private void validateLineHasLeastTwoStation(String name) {
        if (LineRepository.searchLineByName(name).sectionLength() <= 2) {
            throw new IllegalArgumentException("[ERROR] 노선에 등록된 상행, 하행 종점은 삭제할 수 없습니다.");
        }
    }

}
