package subway.system.view;

public class SubwayManagerView {

    static final String SUBWAY_MAIN_TITLE = "## 메인 화면";
    static final String MANAGE_STATION_OPTION = "1. 역 관리";
    static final String MANAGE_LINE_OPTION = "2. 노선 관리";
    static final String MANAGE_SECTION_OPTION = "3. 구간 관리";
    static final String PRINT_MAP_OPTION = "4. 지하철 노선도 출력";
    static final String Q_QUIT_OPTION = "Q. 종료";

    public static void printSubwayManagerMainScreen() {
        System.out.println(SUBWAY_MAIN_TITLE);
        System.out.println(MANAGE_STATION_OPTION);
        System.out.println(MANAGE_LINE_OPTION);
        System.out.println(MANAGE_SECTION_OPTION);
        System.out.println(PRINT_MAP_OPTION);
        System.out.println(Q_QUIT_OPTION);
        System.out.println();
    }
}
