package subway.main;

public class PrintMainScreen {
    private static final String SCREEN
        = "\n## 메인 화면\n"
        + "1. 역 관리\n"
        + "2. 노선 관리\n"
        + "3. 구간 관리\n"
        + "4. 지하철 노선도 출력\n"
        + "Q. 종료";

    public static void printMainScreen() {
        System.out.println(SCREEN);
    }
}
