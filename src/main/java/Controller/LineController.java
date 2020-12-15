package Controller;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LineController {

    public static void runLineController(Scanner scanner) {
        System.out.println("## 노선 관리 화면\n" +
                "1. 노선 등록\n" +
                "2. 노선 삭제\n" +
                "3. 노선 조회\n" +
                "B. 돌아가기\n" +
                "\n" +
                "## 원하는 기능을 선택하세요.");

        String userInput = scanner.nextLine();
        boolean inputCheck = false;
        if (userInput.equals("1")) {
            inputCheck = true;
            addLine(scanner);
        }
        if (userInput.equals("2")) {
            inputCheck = true;
        }
        if (userInput.equals("3")) {
            showLine();
            inputCheck = true;
        }
        if (userInput.equals("B")) {
            inputCheck = true;
            SubwayController.run(scanner);
        }
        if (inputCheck == false) {
            System.out.println("[ERROR] 올바른 번호를 입력해주세요");
            LineController.runLineController(scanner);
        }
    }
    public static void addLine(Scanner scanner) {
        System.out.println("지하철 노선이 등록되었습니다.");
    }
    static void showLine() {
        System.out.println("## 노선 목록");
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            System.out.println(line.getName());
        }
    }
}
