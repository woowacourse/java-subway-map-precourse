package subway.view.station;

import subway.common.Prefix;
import subway.station.Station;

import java.util.List;

public class StationManagementView {
    private static final String STATION_MANAGEMENT_TITLE = Prefix.START.getPrefix() + "역 관리 화면";
    private static final String ADD_STATION = "1. 역 등록";
    private static final String DELETE_STATION = "2. 역 삭제";
    private static final String PRINT_STATION = "3. 역 조회";
    private static final String GO_BACK = "B. 돌아가기";

    private static final String COMPLETE_ADD_STATION = Prefix.INFO.getPrefix() + "지하철 역이 등록되었습니다.";
    private static final String COMPLETE_DELETE_STATION = Prefix.INFO.getPrefix() + "지하철 역이 삭제되었습니다.";

    private static final String ENTER_NEW_STATION = Prefix.START.getPrefix() + "등록할 역 이름을 입력하세요.";
    private static final String ENTER_DELETE_STATION = Prefix.START.getPrefix() + "삭제할 역 이름을 입력하세요.";

    private static final String STATION_LIST_TITLE = Prefix.START.getPrefix() + "역 목록";

    public static void showStationManagementMenu() {
        System.out.println(STATION_MANAGEMENT_TITLE);
        System.out.println(ADD_STATION);
        System.out.println(DELETE_STATION);
        System.out.println(PRINT_STATION);
        System.out.println(GO_BACK);
        System.out.println();
    }

    public static void askNewStationName() {
        System.out.println(ENTER_NEW_STATION);
    }

    public static void askDeleteStationName() {
        System.out.println(ENTER_DELETE_STATION);
    }

    public static void addStationComplete() {
        System.out.println(COMPLETE_ADD_STATION);
        System.out.println();
    }

    public static void deleteStationComplete() {
        System.out.println(COMPLETE_DELETE_STATION);
        System.out.println();
    }

    public static void printAllStation(List<Station> stations) {
        System.out.println(STATION_LIST_TITLE);
        for (Station station : stations) {
            System.out.println(Prefix.INFO.getPrefix() + station.getName());
        }
        System.out.println();
    }
}
