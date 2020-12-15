package subway.domain;

import java.util.List;

public class printScreen {

    public static void printMainScreen() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료\n");
        printSelectFunction();
    }

    public static void printStationManagementScreen() {
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기\n");
        printSelectFunction();
    }

    public static void printSelectFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void printAddStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
    }

    public static void printAlarmAddStation() {
        System.out.println("[INFO] 지하철 역이 등록되었습니다.\n");
    }

    public static void printDeleteStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
    }

    public static void printAlarmDeleteStation() {
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.\n");
    }

    public static void printStationList(List<Station> stations) {
        System.out.println("## 역 목록");

        for (int i = 0; i < stations.size(); i++) {
            System.out.println("[INFO] " + stations.get(i).getName());
        }
        System.out.println();
    }

    public static void printLineManagementScreen() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기\n");
        printSelectFunction();
    }

    public static void printAddLine() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
    }

    public static void printFirstAddLine() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public static void printLastAddLine() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }

    public static void printAlarmAddLine() {
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.\n");
    }

    public static void printDeleteLine() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
    }

    public static void printAlarmDeleteLine() {
        System.out.println("[INFO] 구간이 삭제되었습니다.\n");
    }

    public static void printLineList(List<Line> lines) {
        System.out.println("## 노선 목록");

        for (int i = 0; i < lines.size(); i++) {
            System.out.println("[INFO] " + lines.get(i).getName());
        }
        System.out.println();
    }

    public static void printSectionManagementScreen() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기\n");
        printSelectFunction();
    }

    public static void printInputAddLine() {
        System.out.println("## 노선을 입력하세요.");
    }

    public static void printInputAddStation() {
        System.out.println("## 역이름을 입력하세요.");
    }

    public static void printInputOrder() {
        System.out.println("## 순서를 입력하세요.");
    }

    public static void printAlarmAddSection() {
        System.out.println("[INFO] 구간이 등록되었습니다.\n");
    }

    public static void printInputDeleteLine() {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
    }

    public static void printInputDeleteStation() {
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
    }

    public static void printAlarmDeleteSection() {
        System.out.println("[INFO] 구간이 삭제되었습니다.\n");
    }

    public static void printAllSubwayLine() {
        List<Line> lines = LineRepository.retrieveLine();

        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
            System.out.println("---");
            List<Station> section = line.getSection();
            for (Station station : section) {
                System.out.println("[INFO] " + station.getName());
            }
            System.out.println();
        }
    }
}
