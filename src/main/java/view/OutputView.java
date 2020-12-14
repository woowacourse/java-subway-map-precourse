package view;

public class OutputView {

    static final String SUBWAY_MAIN_TITLE = "## 메인 화면";
    static final String MANAGE_STATION_OPTION = "1. 역 관리";
    static final String MANAGE_LINE_OPTION = "2. 노선 관리";
    static final String MANAGE_SECTION_OPTION = "3. 구간 관리";
    static final String PRINT_MAP_OPTION = "4. 지하철 노선도 출력";
    static final String Q_QUIT_OPTION = "Q. 종료";

    static final String STATION_MANAGER_MAIN_TITLE = "## 역 관리 화면";
    static final String STATION_ENROLLMENT = "1. 역 등록";
    static final String STATION_DELETION = "2. 역 삭제";
    static final String STATION_SEARCH = "3. 역 조회";
    static final String B_QUIT_OPTION = "Q. 종료";

    public static final String LINE_MAIN_TITLE = "## 노선 관리 화면";
    public static final String LINE_ENROLLMENT = "1. 노선 등록";
    public static final String LINE_DELETION = "2. 노선 삭제";
    public static final String LINE_SEARCH = "3. 노선 조회";

    public static final String SECTION_MAIN_TITLE = "## 구간 관리 화면";
    public static final String SECTION_ENROLLMENT = "1. 구간 등록";
    public static final String SECTION_DELETION = "2. 구간 삭제";

    public static void printSubwayManagerMainScreen() {
        System.out.println(SUBWAY_MAIN_TITLE);
        System.out.println(MANAGE_STATION_OPTION);
        System.out.println(MANAGE_LINE_OPTION);
        System.out.println(MANAGE_SECTION_OPTION);
        System.out.println(PRINT_MAP_OPTION);
        System.out.println(Q_QUIT_OPTION);
        System.out.println();
    }

    public static void printStationManagerMainScreen() {
        System.out.println(STATION_MANAGER_MAIN_TITLE);
        System.out.println(STATION_ENROLLMENT);
        System.out.println(STATION_DELETION);
        System.out.println(STATION_SEARCH);
        System.out.println(B_QUIT_OPTION);
        System.out.println();
    }

    public static void printLineManagerMainScreen() {
        System.out.println(LINE_MAIN_TITLE);
        System.out.println(LINE_ENROLLMENT);
        System.out.println(LINE_DELETION);
        System.out.println(LINE_SEARCH);
        System.out.println(B_QUIT_OPTION);
        System.out.println();
    }

    public static void printSectionManagerMainScreen() {
        System.out.println(SECTION_MAIN_TITLE);
        System.out.println(SECTION_ENROLLMENT);
        System.out.println(SECTION_DELETION);
        System.out.println(B_QUIT_OPTION);
        System.out.println();
    }
}
