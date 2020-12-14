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
            validateLine(line);
            validateStation(station);
            LineRepository.searchStationByName(line).addStationToSection(Integer.parseInt(index) - 1, station);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            run();
        }
    }

    private void validateLine(String line) {
        if (!LineRepository.hasLine(line)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 노선입니다.");
        }
    }

    private void validateStation(String station) {
        if (!StationRepository.hasStation(station)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
        }
    }

    private void deleteLine() {
        System.out.println("\n## 노선을 입력하세요.");
        String line = InputView.askName(scanner);
        try {
            validateLine(line);
            LineRepository.deleteLineByName(line);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            run();
        }
    }

}
