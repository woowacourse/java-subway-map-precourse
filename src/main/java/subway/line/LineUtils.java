package subway.line;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;
import java.util.Scanner;

public class LineUtils {
    private Scanner scanner;
    
    public LineUtils(Scanner scanner) {
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
            registerLine();
        }
        if (number == 2) {
            deleteLine();
        }
        if (number == 3) {
            showLine();
        }
    }

    public void registerLine() {
        Station upTerminal;
        Station downTerminal;

        System.out.println("## 등록할 노선 이름을 입력하세요.");
        Line newLine = new Line(scanner.next());

        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        upTerminal = StationRepository.getStationByName(scanner.next());

        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        downTerminal = StationRepository.getStationByName(scanner.next());

        newLine.setTerminal(upTerminal, downTerminal);
        LineRepository.addLine(newLine);
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
    }

    public void deleteLine() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        LineRepository.deleteLineByName(scanner.next());
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public void showLine() {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
        }
    }
}
