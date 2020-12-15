package subway.view;

import java.util.List;

public class PrintInfo {
    public static void mainMenu() {
        System.out.println(
                "## 메인 화면\n" +
                "1. 역 관리\n" +
                "2. 노선 관리\n" +
                "3. 구간 관리\n" +
                "4. 지하철 노선도 출력\n" +
                "Q. 종료\n" +
                "\n" +
                "## 원하는 기능을 선택하세요.");
    }

    
    
    public static void manageStation() {
        System.out.println(
                "## 역 관리 화면\n" +
                "1. 역 등록\n" +
                "2. 역 삭제\n" +
                "3. 역 조회\n" +
                "B. 돌아가기\n" +
                "\n" +
                "## 원하는 기능을 선택하세요.");
    }

    public static void inputAddStationName() {
        System.out.println("\n" +
                "## 등록할 역 이름을 입력하세요.");
    }

    public static void addStationSuccess() {
        System.out.println("\n" +
                "[INFO] 지하철 역이 등록되었습니다.\n");
    }

    public static void inputDeleteStationName() {
        System.out.println("\n" +
                "## 삭제할 역 이름을 입력하세요.");
    }

    public static void deleteStationSuccess() {
        System.out.println("\n" +
                "[INFO] 지하철 역이 삭제되었습니다.\n");
    }

    public static void stations(List<String> list) {
        System.out.println("\n" +
                "## 역 목록");
        printList(list);
    }



    public static void manageLine() {
        System.out.println(
                "## 노선 관리 화면\n" +
                "1. 노선 등록\n" +
                "2. 노선 삭제\n" +
                "3. 노선 조회\n" +
                "B. 돌아가기\n" +
                "\n" +
                "## 원하는 기능을 선택하세요.");
    }

    public static void inputAddLineName() {
        System.out.println("\n" +
                "## 등록할 노선 이름을 입력하세요.");
    }

    public static void inputAddLineStartStation() {
        System.out.println("\n" +
                "## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public static void inputAddLineEndStation() {
        System.out.println("\n" +
                "## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }

    public static void addLineSuccess() {
        System.out.println("\n" +
                "[INFO] 지하철 노선이 등록되었습니다.\n");
    }

    public static void inputDeleteLineName() {
        System.out.println("\n" +
                "## 삭제할 노선 이름을 입력하세요.");
    }

    public static void deleteLineSuccess() {
        System.out.println("\n" +
                "[INFO] 지하철 노선이 삭제되었습니다.\n");
    }

    public static void allLines(List<String> list) {
        System.out.println("\n" +
                "## 노선 목록");
        printList(list);
    }



    public static void manageSection() {
        System.out.println(
                "## 구간 관리 화면\n" +
                "1. 구간 등록\n" +
                "2. 구간 삭제\n" +
                "B. 돌아가기\n" +
                "\n" +
                "## 원하는 기능을 선택하세요.");
    }

    public static void inputAddSectionLineName() {
        System.out.println("\n" +
                "## 노선을 입력하세요.");
    }

    public static void inputAddSectionStationName() {
        System.out.println("\n" +
                "## 역이름을 입력하세요.");
    }

    public static void inputAddSectionIndex() {
        System.out.println("\n" +
                "## 순서를 입력하세요.");
    }

    public static void addSectionSuccess() {
        System.out.println("\n" +
                "[INFO] 구간이 등록되었습니다.\n");
    }

    public static void inputDeleteSectionLineName() {
        System.out.println("\n" +
                "## 삭제할 구간의 노선을 입력하세요.");
    }

    public static void inputDeleteSectionStationName() {
        System.out.println("\n" +
                "## 삭제할 구간의 역을 입력하세요.");
    }

    public static void deleteSectionSuccess() {
        System.out.println("\n" +
                "[INFO] 구간이 삭제되었습니다.\n");
    }

    public static void printList(List<String> list) {
        list.forEach(item -> System.out.println("[INFO] " + item));
        System.out.println();
    }
}
