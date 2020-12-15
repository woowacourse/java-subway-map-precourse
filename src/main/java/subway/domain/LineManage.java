package subway.domain;

import java.util.Arrays;
import java.util.Scanner;

import static subway.Application.startProgram;

public class LineManage {
    public static void manageLine(Scanner kbd) {
        View.showLineMenu();
        String input = InputView.inputFunction(kbd, Constants.SUB_FUNCTIONS);
        if (input.equals(Constants.ADD_MENU))
            addLine(kbd);
        if (input.equals(Constants.DELETE_MENU))
            deleteLine(kbd);
        if (input.equals(Constants.SEARCH_MENU))
            searchLine(kbd);
        if (input.equalsIgnoreCase(Constants.GO_BACK_MENU))
            startProgram(kbd);
    }

    public static void addLine(Scanner kbd) {
        try {
            makeNewLine(kbd);
            System.out.println("\n[INFO] 지하철 노선이 등록되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void makeNewLine(Scanner kbd) throws IllegalArgumentException {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        String lineName = kbd.nextLine();
        Errors.checkSameLine(lineName);
        Errors.checkTextLength(lineName);
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String firstStation = kbd.nextLine();
        Errors.checkExistStation(firstStation);
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String lastStation = kbd.nextLine();
        Errors.checkExistStation(lastStation);
        Errors.checkSameName(firstStation, lastStation);
        Line newLine = new Line(lineName);
        LineRepository.addLine(newLine, Arrays.asList(firstStation, lastStation));
    }

    public static void deleteLine(Scanner kbd) {
        try {
            System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
            String lineName = kbd.nextLine();
            Errors.checkExistLine(lineName);
            LineRepository.deleteLineByName(lineName);
            System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void searchLine(Scanner kbd) {
        System.out.println("\n## 노선 목록");
        for (Line line : LineRepository.lines())
            System.out.println("[INFO] " + line.getName());
        startProgram(kbd);
    }
}
