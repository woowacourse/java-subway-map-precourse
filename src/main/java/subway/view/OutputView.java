package subway.view;

public class OutputView {
    private static final String MAINSCREEN = "## 메인 화면\n1. 역관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    private static final String ORDERTOCHOOSECOMMAND = "## 원하는 기능을 선택하세요.";

    public static void printMainScreen() {
        System.out.println(MAINSCREEN);
        printOrderToChooseCommand();
    }

    public static void printOrderToChooseCommand() {
        System.out.println(ORDERTOCHOOSECOMMAND);
    }
}
