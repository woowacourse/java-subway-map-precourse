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

    public static void printDeleteStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
    }

    public static void printStationList(List<Station> stations) {
        System.out.println("## 역 목록");

        for (int i = 0; i < stations.size(); i++) {
            System.out.println("[INFO] "+ stations.get(i));
        }
    }
}
