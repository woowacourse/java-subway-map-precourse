package subway.station.view;

public class StationOutputView {
    private static final String STATION_MANAGEMENT_TITLE = "## 역 관리 화면";
    private static final String ADD_STATION = "1. 역 등록";
    private static final String DELETE_STATION = "2. 역 삭제";
    private static final String PRINT_STATION = "3. 역 조회";
    private static final String GO_BACK = "B. 돌아가기";
    private static final String RESULT_PREFIX = "[INFO] ";
    private static final String COMPLETE_ADD_STATION = RESULT_PREFIX + "지하철 역이 등록되었습니다.";

    public static void printStationManagement() {
        System.out.println(STATION_MANAGEMENT_TITLE);
        System.out.println(ADD_STATION);
        System.out.println(DELETE_STATION);
        System.out.println(PRINT_STATION);
        System.out.println(GO_BACK);
        System.out.println();
    }

    public static void addStationComplete() {
        System.out.println(COMPLETE_ADD_STATION);
        System.out.println();
    }
}
