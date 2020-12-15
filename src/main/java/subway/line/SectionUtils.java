package subway.line;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.Validator;

import java.util.List;
import java.util.Scanner;

public class SectionUtils {
    private final int SECTION_REGISTER = 1;
    private final int SECTION_DELETE = 2;
    private final int SECTION_BACK = 0;
    private Scanner scanner;

    public SectionUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        String chosen;
        int chosenNumber;

        System.out.println("## 구간 관리 화면\n" +
                "1. 구간 등록\n" +
                "2. 구간 삭제\n" +
                "B. 돌아가기\n");
        System.out.println("## 원하는 기능을 선택하세요.");
        chosen = scanner.next();
        if (!chosen.equals("B")) {
            chosenNumber = Validator.isSectionInputRight(chosen);
            choose(chosenNumber);
        }
    }

    public void choose(int chosenNumber) {
        if (chosenNumber == SECTION_BACK) {
        }
        if (chosenNumber == SECTION_REGISTER) {
            registerSection();
        }
        if (chosenNumber == SECTION_DELETE) {
            deleteSection();
        }
    }

    public void registerSection() {
        Station selectedStation;
        Line selectedLine;
        int lineIndex;

        System.out.println("\n## 노선을 입력하세요.");
        String selectedLineName = scanner.next();
        Validator.isLineExist(selectedLineName);
        selectedLine = LineRepository.selectLineByName(selectedLineName);
        System.out.println("\n## 역이름을 입력하세요.");
        String selectedStationName = scanner.next();
        Validator.isStationExist(selectedStationName);
        selectedStation = StationRepository.getStationByName(selectedStationName);
        System.out.println("\n## 순서를 입력하세요.");
        lineIndex = scanner.nextInt();
        Validator.isIndexInBound(lineIndex);
        selectedLine.addStation(lineIndex, selectedStation);
        System.out.println("\n[INFO] 구간이 등록되었습니다.\n");
    }

    public void deleteSection() {
        Line selectedLine;

        System.out.println("\n## 삭제할 구간의 노선을 입력하세요.");
        String selectedLineName = scanner.next();
        Validator.isLineExist(selectedLineName);
        selectedLine = LineRepository.selectLineByName(selectedLineName);

        System.out.println("\n## 삭제할 구간의 역을 입력하세요.");
        String deleteStationName = scanner.next();
        Validator.isStationExist(deleteStationName);
        selectedLine.deleteStation(deleteStationName);

        System.out.println("\n[INFO] 구간이 삭제되었습니다.\n");
    }

}

