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
    private static final String STATION_MANAGEMENT_VIEW = "1. 역 관리";
    private static final String LINE_MANAGEMENT_VIEW = "2. 노선 관리";
    private static final String SECTION_MANAGEMENT_VIEW = "3. 구간 관리";
    private static final String SUBWAY_ROUTE_MAP_PRINT_VIEW = "4. 지하철 노선도 출력";
    private static final String QUIT_VIEW = "Q. 종료";

    public static void printLines(List<Line> lines) {
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

    public static void printMain() {
        System.out.println(MAIN_VIEW);
        System.out.println(STATION_MANAGEMENT_VIEW);
        System.out.println(LINE_MANAGEMENT_VIEW);
        System.out.println(SECTION_MANAGEMENT_VIEW);
        System.out.println(SUBWAY_ROUTE_MAP_PRINT_VIEW);
        System.out.println(QUIT_VIEW);
    }
}
