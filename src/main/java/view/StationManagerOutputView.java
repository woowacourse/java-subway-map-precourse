package view;

public class StationManagerOutputView {

    static final String STATION_MANAGER_MAIN_TITLE = "## 역 관리 화면";
    static final String STATION_ENROLLMENT = "1. 역 등록";
    static final String STATION_DELETION = "2. 역 삭제";
    static final String STATION_SEARCH = "3. 역 조회";
    static final String B_QUIT_OPTION = "B. 종료";

    public static void printStationManagerMainScreen() {
        System.out.println(STATION_MANAGER_MAIN_TITLE);
        System.out.println(STATION_ENROLLMENT);
        System.out.println(STATION_DELETION);
        System.out.println(STATION_SEARCH);
        System.out.println(B_QUIT_OPTION);
        System.out.println();
    }

}
