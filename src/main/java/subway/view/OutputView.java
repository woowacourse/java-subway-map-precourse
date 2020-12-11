package subway.view;

public class OutputView {

    private static final String MAIN_SCREEN = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    private static final String MENU_SELECT_SCREEN = "## 원하는 기능을 선택하세요.";

    private OutputView() {
    }

    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN);
    }

    public static void printMenuSelectScreen() {
        System.out.println(MENU_SELECT_SCREEN);
    }
}
