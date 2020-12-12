package subway.view;

public class OutputView {

    private static final String MAIN_SCREEN = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    private static final String STATION_MANAGEMENT_SCREEN = "## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기\n";
    private static final String LINE_MANAGEMENT_SCREEN = "## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기\n";
    private static final String EDGE_MANAGEMENT_SCREEN = "## 구간 관리 화면\n1. 구간 등록\2. 구간 삭제\nB. 돌아가기";
    private static final String MENU_SELECT_SCREEN = "## 원하는 기능을 선택하세요.";

    private OutputView() {
    }

    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN);
    }

    public static void printStationManagementScreen() {
        System.out.println(STATION_MANAGEMENT_SCREEN);
    }

    public static void printLineManagementScreen() {
        System.out.println(LINE_MANAGEMENT_SCREEN);
    }

    public static void printEdgeManagementScreen() {
        System.out.println(EDGE_MANAGEMENT_SCREEN);
    }

    public static void printMenuSelectScreen() {
        System.out.println(MENU_SELECT_SCREEN);
    }
}
