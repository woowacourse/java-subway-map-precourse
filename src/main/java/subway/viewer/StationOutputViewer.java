package subway.viewer;

import subway.domain.Station;

import java.util.List;

public class StationOutputViewer {
    private static final String COMPLETE_ENROLL_MESSAGE = "[INFO] 지하철 역이 등록되었습니다.";
    private static final String COMPLETE_DELETE_MESSAGE = "[INFO] 지하철 역이 삭제 되었습니다.";
    private static final String SHOW_STATION_LIST = "## 역 목록";
    private static final String SHOW_STATION_UNIT = "[INFO] %s\n";

    public static void showEnrollStation() {
        System.out.println();
        System.out.println(COMPLETE_ENROLL_MESSAGE);
    }

    public static void showDeleteStation() {
        System.out.println();
        System.out.println(COMPLETE_DELETE_MESSAGE);
    }

    public static void showStationList(List<Station> stations) {
        System.out.println();
        System.out.println(SHOW_STATION_LIST);
        for (Station station : stations) {
            System.out.printf(SHOW_STATION_UNIT, station.getName());
        }
        System.out.println();
    }
}
