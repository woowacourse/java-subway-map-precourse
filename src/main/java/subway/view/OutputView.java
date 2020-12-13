package subway.view;

import subway.domain.line.model.Line;
import subway.domain.station.model.Station;

import java.util.List;

public class OutputView {
    private static final String INFO_MESSAGE = "[INFO] ";
    private static final String RESULT_VIEW_DIVIDER = "---";
    private static final String SUBWAY_ROUTE_MAP_LIST_MESSAGE = "## 지하철 노선도";
    private static final String STATIONS_LIST_MESSAGE = "## 역 목록";
    private static final String MAIN_VIEW = "## 메인화면";
    private static final String STATION_MANAGEMENT_MENU = "1. 역 관리";
    private static final String LINE_MANAGEMENT_MENU = "2. 노선 관리";
    private static final String SECTION_MANAGEMENT_MENU = "3. 구간 관리";
    private static final String SUBWAY_ROUTE_MAP_PRINT_MENU = "4. 지하철 노선도 출력";
    private static final String QUIT_MENU = "Q. 종료\n";
    private static final String STATION_MANAGEMENT_VIEW = "## 역 관리 화면";
    private static final String STATION_RESITER_MENU = "1. 역 등록";
    private static final String STATION_REMOVE_MENU = "2. 역 삭제";
    private static final String STATION_CHECK_MENU = "3. 역 조회";
    private static final String RETURN_MENU = "B. 돌아가기\n";
    private static final String LINE_MANAGEMENT_VIEW = "## 노선 관리 화면";
    private static final String LINE_RESITER_MENU = "1. 노선 등록";
    private static final String LINE_DELETE_MENU = "2. 노선 삭제";
    private static final String LINE_CHECK_MENU = "3. 노선 조회";
    private static final String SECTION_MANAGEMENT_VIEW = "## 구간 관리 화면";
    private static final String SECTION_RESITER_MENU = "1. 구간 등록";
    private static final String SECTION_DELETE_MENU = "2. 구간 삭제";
    private static final String INFO_EXIT_MESSAGE = "## 지하철 노선 프로그램을 종료햡니다.";
    private static final String LINES_LIST_MESSAGE = "## 노선 목록";

    public static void printSubwayRouteMap(List<Line> lines) {
        System.out.println(SUBWAY_ROUTE_MAP_LIST_MESSAGE);
        for (Line line : lines) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        List<Station> stations = line.getStations();
        System.out.println(INFO_MESSAGE + line.getName());
        System.out.println(INFO_MESSAGE + RESULT_VIEW_DIVIDER);
        for (Station station : stations) {
            System.out.println(INFO_MESSAGE + station.getName());
        }
        System.out.println();
    }

    public static void printStations(List<Station> stations) {
        System.out.println(STATIONS_LIST_MESSAGE);
        for (Station station : stations) {
            System.out.println(INFO_MESSAGE + station.getName());
        }
        System.out.println();
    }

    public static void printMainMenu() {
        System.out.println(MAIN_VIEW);
        System.out.println(STATION_MANAGEMENT_MENU);
        System.out.println(LINE_MANAGEMENT_MENU);
        System.out.println(SECTION_MANAGEMENT_MENU);
        System.out.println(SUBWAY_ROUTE_MAP_PRINT_MENU);
        System.out.println(QUIT_MENU);
    }

    public static void printStationManagementMenu() {
        System.out.println(STATION_MANAGEMENT_VIEW);
        System.out.println(STATION_RESITER_MENU);
        System.out.println(STATION_REMOVE_MENU);
        System.out.println(STATION_CHECK_MENU);
        System.out.println(RETURN_MENU);
    }

    public static void printLineManagementMenu() {
        System.out.println(LINE_MANAGEMENT_VIEW);
        System.out.println(LINE_RESITER_MENU);
        System.out.println(LINE_DELETE_MENU);
        System.out.println(LINE_CHECK_MENU);
        System.out.println(RETURN_MENU);
    }

    public static void printSectionManagementMenu() {
        System.out.println(SECTION_MANAGEMENT_VIEW);
        System.out.println(SECTION_RESITER_MENU);
        System.out.println(SECTION_DELETE_MENU);
        System.out.println(RETURN_MENU);
    }

    public static void printExit() {
        System.out.println(INFO_EXIT_MESSAGE);
    }
}
