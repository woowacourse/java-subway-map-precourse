package subway.views.stationviews;

import subway.menus.StationMenu;

import java.util.Arrays;

public class StationOutputView {
    private static final String STATION_MANAGE_PAGE = "## 역 관리 화면";
    private static final String STATION_INSERT_SUCCESS_MESSAGE = "\n[INFO] 지하철 역이 등록되었습니다.\n";
    private static final String LINE_WRAP = "\n";

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

    public static void printInsertSuccess() {
        System.out.println(STATION_INSERT_SUCCESS_MESSAGE);
    }
}
