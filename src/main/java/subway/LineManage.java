package subway;

import static subway.domain.LineRepository.addLine;
import static subway.domain.LineRepository.deleteLineByName;
import static subway.domain.LineRepository.hasLine;
import static subway.domain.StationRepository.hasStation;

import java.util.Scanner;
import subway.domain.Line;

public class LineManage {

    static final String ADD_LINE = "1";
    static final String DELETE_LINE = "2";
    static final String ALL_LINES = "3";
    static final String BACK_SCREEN = "B";
    static final int MIN_LINE_NAME_LENGTH = 2;

    static public void linaManage(Scanner scanner) {
        lineManagePrint();
        String lineManageInput = scanner.next();
        inputValidate(scanner, lineManageInput);
    }

    private static boolean inputValidate(Scanner scanner, String mainInput) {
        if (mainInput.equalsIgnoreCase(ADD_LINE)) {
            addLinePrint(scanner);
            return true;
        }
        if (mainInput.equalsIgnoreCase(DELETE_LINE)) {
            deleteLinePrint(scanner);
            return true;
        }
        if (mainInput.equalsIgnoreCase(ALL_LINES)) {
            //allLinesPrint();
            return true;
        }
        if (mainInput.equalsIgnoreCase(BACK_SCREEN)) {
            return true;
        }
        System.out.println("\n[ERROR] 선택할 수 없는 기능입니다.");
        throw new IllegalArgumentException();
    }

    private static void addLinePrint(Scanner scanner) {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        String lineName = scanner.next();
        lineNameValidate(lineName);
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String upwardTerminal = scanner.next();
        terminalNameValidate(upwardTerminal);
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String downWardTerminal = scanner.next();
        terminalNameValidate(downWardTerminal);
        addLine(new Line(lineName));
        System.out.println("\n[INFO] 지하철 노선이 등록되었습니다.");
    }

    private static void deleteLinePrint(Scanner scanner) {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
        String lineName = scanner.next();
        if (!lineExists(lineName)) {
            System.out.println("\n[ERROR] 존재하지 않는 노선 이름입니다. ");
            throw new IllegalArgumentException();
        }
        deleteLineByName(lineName);
        System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.");
    }

    private static void lineNameValidate(String lineName) {
        if (!lineNameLengthValidate(lineName)) {
            System.out.println("\n[ERROR] 노선의 이름은 최소 2자 이상이어야 합니다. ");
            throw new IllegalArgumentException();
        }
        if(lineExists(lineName)) {
            System.out.println("\n[ERROR] 이미 등록된 노선 이름입니다. ");
            throw new IllegalArgumentException();
        }
    }

    private static boolean lineNameLengthValidate(String lineName) {
        return lineName.length() >= MIN_LINE_NAME_LENGTH;
    }

    private static boolean lineExists(String lineName) {
        return hasLine(lineName);
    }

    private static void terminalNameValidate(String terminalName) {
        if (!hasStation(terminalName)) {
            System.out.println("\n[ERROR] 해당 역이 존재하지 않습니다. ");
            throw new IllegalArgumentException();
        }
    }

    private static void lineManagePrint() {
        System.out.println("\n## 노선 관리 화면\n"
            + "1. 노선 등록\n"
            + "2. 노선 삭제\n"
            + "3. 노선 조회\n"
            + "B. 돌아가기\n"
            + "\n"
            + "## 원하는 기능을 선택하세요.");
    }
}
