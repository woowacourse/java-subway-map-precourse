package subway.line;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;
import java.util.Scanner;

public class SectionUtils {
    private Scanner scanner;

    public SectionUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        while (true) {
            System.out.println("## 원하는 기능을 선택하세요.");
            String chosen = scanner.next();
            if (chosen.equals("B")) {
                break;
            }
            choose(chosen);
        }
    }

    public void choose(String chosen) {
        int number = Integer.parseInt(chosen);

        if (number == 1) {
            registerSection();
        }
        if (number == 2) {
            deleteSection();
        }
    }

    public void registerSection() {
        Station selectedStation;
        Line selectedLine;
        int lineIndex;

        System.out.println("## 노선을 입력하세요.");
        selectedLine = LineRepository.selectLineByName(scanner.next());
        System.out.println("## 역이름을 입력하세요.");
        selectedStation = StationRepository.getStationByName(scanner.next());
        System.out.println("## 순서를 입력하세요.");
        lineIndex = scanner.nextInt();
        selectedLine.addStation(lineIndex, selectedStation);
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    public void deleteSection() {
        Line selectedLine;

        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        selectedLine = LineRepository.selectLineByName(scanner.next());

        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        selectedLine.deleteStation(scanner.next());

        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }

}

