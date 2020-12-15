package subway.line;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.Validator;

import java.util.List;
import java.util.Scanner;

public class LineUtils {
    private final int LINE_REGISTER = 1;
    private final int LINE_DELETE = 2;
    private final int LINE_SHOW = 3;
    private final int LINE_BACK = 0;
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
        if (chosenNumber == LINE_BACK) {
        }
        if (chosenNumber == LINE_REGISTER) {
            registerLine();
        }
        if (chosenNumber == LINE_DELETE) {
            deleteLine();
        }
        if (chosenNumber == LINE_SHOW) {
            showLine();
        }
    }

    public void registerLine() {
        Station upTerminal;
        Station downTerminal;

        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        String newLineName = scanner.next();
        Validator.isLineAlreadyExist(newLineName);
        Validator.isNameOverTwoCharacter(newLineName);
        Line newLine = new Line(newLineName);

        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String upTermianlName = scanner.next();
        Validator.isStationExist(upTermianlName);
        upTerminal = StationRepository.getStationByName(upTermianlName);

        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String downTerminalName = scanner.next();
        Validator.isStationExist(downTerminalName);
        downTerminal = StationRepository.getStationByName(downTerminalName);

        newLine.setTerminal(upTerminal, downTerminal);
        LineRepository.addLine(newLine);
        System.out.println("\n[INFO] 지하철 노선이 등록되었습니다.\n");
    }

    public void deleteLine() {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
        String deleteLineName = scanner.next();
        Validator.isLineExist(deleteLineName);
        LineRepository.deleteLineByName(deleteLineName);
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
