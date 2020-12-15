package subway.view;

public class StationOutputView {
    private static final String MANAGE_STATION_SCREEN = "## 역 관리 화면";
    private static final String REGISTER_STATION = "1. 역 등록";
    private static final String REMOVE_STATION = "2. 역 삭제";
    private static final String PRINT_STATION = "3. 역 조회";
    private static final String BACK = "B. 돌아가기";

    private StationOutputView() {
    }

    public static void printManageStationScreen() {
        System.out.println();
        System.out.println(MANAGE_STATION_SCREEN);
        System.out.println(REGISTER_STATION);
        System.out.println(REMOVE_STATION);
        System.out.println(PRINT_STATION);
        System.out.println(BACK);
        System.out.println();
    }
}
