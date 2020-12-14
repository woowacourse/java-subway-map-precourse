package subway.views.stationviews;

import subway.domain.Station;
import subway.menus.StationMenu;
import subway.views.OutputView;

import java.util.Arrays;
import java.util.List;

public class StationOutputView implements OutputView {
    private static final String STATION_MANAGE_PAGE = "## 역 관리 화면";
    private static final String STATIONS_LIST_MESSAGE = "## 역 목록";
    private static final String STATION_ADD_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.\n";
    private static final String STATION_DELETE_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.\n";


    public static void printStationManagePage() {
        System.out.println(LINE_WRAP + STATION_MANAGE_PAGE);
        printStationManageMenus();
        System.out.println();
    }

    private static void printStationManageMenus() {
        Arrays.stream(StationMenu.values())
            .map(StationMenu::toString)
            .forEach(System.out::println);
    }

    public static void printAddSuccess() {
        System.out.println(LINE_WRAP + INFO_PREFIX + STATION_ADD_SUCCESS_MESSAGE);
    }

    public static void printDeleteSuccess() {
        System.out.println(LINE_WRAP + INFO_PREFIX + STATION_DELETE_SUCCESS_MESSAGE);
    }

    public static void printStations(List<Station> stations) {
        System.out.println(LINE_WRAP + STATIONS_LIST_MESSAGE);
        stations.stream()
            .map(Station::getName)
            .forEach(name -> System.out.println(INFO_PREFIX + name));
        System.out.println();
    }
}
