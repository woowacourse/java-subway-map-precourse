package subway.view;

public class OutputView {
    private static final String MAIN_SCREEN = "## 메인 화면";
    private static final String MANAGE_STATION = "1. 역 관리";
    private static final String MANAGE_LINE = "2. 노선 관리";
    private static final String MANAGE_SECTION = "3. 구간 관리";
    private static final String PRINT_MAP = "4. 지하철 노선도 출력";
    private static final String QUIT = "Q. 종료";
    private static final String SELECT_MESSAGE = "## 원하는 기능을 선택하세요.";

    private OutputView() {
    }

    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN);
        System.out.println(MANAGE_STATION);
        System.out.println(MANAGE_LINE);
        System.out.println(MANAGE_SECTION);
        System.out.println(PRINT_MAP);
        System.out.println(QUIT);
        System.out.println();
        System.out.println(SELECT_MESSAGE);
    }





}
