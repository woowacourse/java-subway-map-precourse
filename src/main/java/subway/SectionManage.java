package subway;

import static subway.LineManage.lineExists;
import static subway.StationManage.stationExists;
import static subway.domain.LineRepository.deleteLineByName;

import java.util.Scanner;

public class SectionManage {

    static final String ADD_SECTION = "1";
    static final String DELETE_SECTION = "2";
    static final String BACK_SCREEN = "B";
    static final int MIN_TERMINAL_SIZE = 2;

    static public void sectionManage(Scanner scanner) {
        sectionManagePrint();
        String sectionManageInput = scanner.next();
        inputValidate(scanner, sectionManageInput);
    }

    private static void inputValidate(Scanner scanner, String sectionManageInput) {
        if (sectionManageInput.equalsIgnoreCase(ADD_SECTION)) {
            addSectionPrint(scanner);
            return;
        }
        if (sectionManageInput.equalsIgnoreCase(DELETE_SECTION)) {
            //deleteSectionPrint(scanner);
            return;
        }
        if (sectionManageInput.equalsIgnoreCase(BACK_SCREEN)) {
            return;
        }
        System.out.println("\n[ERROR] 선택할 수 없는 기능입니다.");
        throw new IllegalArgumentException();
    }

    private static void addSectionPrint(Scanner scanner) {
        System.out.println("\n## 노선 이름을 입력하세요.");
        String lineName = scanner.next();
        if (!lineExists(lineName)) {
            System.out.println("\n[ERROR] 존재하지 않는 노선 이름입니다. ");
            throw new IllegalArgumentException();
        }
        System.out.println("\n## 역 이름을 입력하세요.");
        String terminalName = scanner.next();
        if (!stationExists(terminalName)) {
            System.out.println("\n[ERROR] 존재하지 않는 역 이름입니다. ");
            throw new IllegalArgumentException();
        }
        System.out.println("\n## 순서를 입력하세요.");
        try {
            int position = scanner.nextInt();
            // position validate 필요
        } catch (Exception e) {
            System.out.println("\n[ERROR] 잘못된 순서입니다. ");
            throw new IllegalArgumentException();
        }
        // linkedlist에 추가 필요
        System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.");
    }

    private static void sectionManagePrint() {
        System.out.println("\n## 구간 관리 화면\n"
            + "1. 구간 등록\n"
            + "2. 구간 삭제\n"
            + "B. 돌아가기\n"
            + "\n"
            + "## 원하는 기능을 선택하세요.");
    }
}
