package subway.view;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.List;

public class OutputView {
    private static final String PRINT_STATION_LIST_MESSAGE = "## 역 목록";
    private static final String PRINT_LINE_LIST_MESSAGE = "## 노선 목록";
    private static final String PRINT_SUBWAY_MAP_MESSAGE = "## 지하철 노선도";
    private static final String PRINT_LIST = "[INFO] %s\n";
    private static final String DASH = "---";
    private static final String ADD_MESSAGE = "[INFO] %s이 등록되었습니다.\n";
    private static final String DELETE_MESSAGE = "[INFO] %s이 삭제되었습니다.\n";
    private static final String SUBWAY = "지하철 ";
    private static final String SECTION = "구간";

    private OutputView() {
    }

    public static void printAddMessage(String kind) {
        if (!kind.equals(SECTION)) {
            kind = SUBWAY + kind;
        }
        System.out.printf(ADD_MESSAGE, kind);
    }
    public static void printDeleteMessage(String kind) {
        if (!kind.equals(SECTION)) {
            kind = SUBWAY + kind;
        }
        System.out.printf(DELETE_MESSAGE, kind);
    }

    public static void printStationList() {
        System.out.println(PRINT_STATION_LIST_MESSAGE);
        StationRepository.stations().stream()
                .map(Station::getName)
                .forEach(name -> System.out.printf(PRINT_LIST, name.getName()));
    }

    public static void printLineList() {
        System.out.println(PRINT_LINE_LIST_MESSAGE);
        LineRepository.lines().stream()
                .map(Line::getName)
                .forEach(name -> System.out.printf(PRINT_LIST, name.getName()));
    }

    public static void printSubwayMap() {
        System.out.println(PRINT_SUBWAY_MAP_MESSAGE);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            System.out.printf(PRINT_LIST, line.getName().getName());
            System.out.printf(PRINT_LIST, DASH);
            line.getStations().stream()
                    .map(Station::getName)
                    .forEach(name -> System.out.printf(PRINT_LIST, name.getName()));
            System.out.println();
        }
    }

}
