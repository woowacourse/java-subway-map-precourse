package subway.line;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.Validator;

import java.util.List;
import java.util.Scanner;

public class LineUtils {
    private Scanner scanner;

    public LineUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        String chosen;
        int chosenNumber;

        System.out.println("## 노선 관리 화면\n" +
                "1. 노선 등록\n" +
                "2. 노선 삭제\n" +
                "3. 노선 조회\n" +
                "B. 돌아가기\n");
        System.out.println("## 원하는 기능을 선택하세요.");
        chosen = scanner.next();
        if (!chosen.equals("B")) {
            chosenNumber = Validator.isInputRight(chosen);
            choose(chosenNumber);
        }
    }

    public void choose(int chosenNumber) {
        if (chosenNumber == 1) {
            registerLine();
        }
        if (chosenNumber == 2) {
            deleteLine();
        }
        if (chosenNumber == 3) {
            showLine();
        }
    }

    public void registerLine() {
        Station upTerminal;
        Station downTerminal;

        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        Line newLine = new Line(scanner.next());

        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        upTerminal = StationRepository.getStationByName(scanner.next());

        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        downTerminal = StationRepository.getStationByName(scanner.next());

        newLine.setTerminal(upTerminal, downTerminal);
        LineRepository.addLine(newLine);
        System.out.println("\n[INFO] 지하철 노선이 등록되었습니다.\n");
    }

    public void deleteLine() {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
        LineRepository.deleteLineByName(scanner.next());
        System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.\n");
    }

    public void showLine() {
        List<Line> lines = LineRepository.lines();
        System.out.println("");
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
        }
        System.out.println("");
    }
}
