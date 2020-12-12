package subway.main.view;

public class MainOutputView {
    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String STATION_MANAGEMENT = "1. 역 관리";
    private static final String LINE_MANAGEMENT = "2. 노선 관리";
    private static final String SECTION_MANAGEMENT = "3. 구간 관리";
    private static final String PRINT_LINE_MAP = "4. 지하철 노선도 출력";
    private static final String EXIT_SERVICE = "Q. 종료";

    public static void printMainSelection() {
        System.out.println(MAIN_TITLE);
        System.out.println(STATION_MANAGEMENT);
        System.out.println(LINE_MANAGEMENT);
        System.out.println(SECTION_MANAGEMENT);
        System.out.println(PRINT_LINE_MAP);
        System.out.println(EXIT_SERVICE);
        System.out.println();
    }
}
