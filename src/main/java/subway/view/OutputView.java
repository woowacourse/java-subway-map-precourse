package subway.view;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.List;

public class OutputView {
    private static final String SUBWAY = "지하철 ";
    private static final String SECTION = "구간";
    private static final String DASH = "---";
    private static final String PRINT_LIST_MESSAGE = "\n## %s 목록\n";
    private static final String PRINT_SUBWAY_MAP_MESSAGE = "\n## 지하철 노선도";
    private static final String PRINT_LIST = "[INFO] %s\n";
    private static final String ADD_MESSAGE = "\n[INFO] %s이 등록되었습니다.\n";
    private static final String DELETE_MESSAGE = "\n[INFO] %s이 삭제되었습니다.\n";


    private OutputView() {
    }

    public static void printAddMessage(String category) {
        if (!category.equals(SECTION)) {
            category = SUBWAY + category;
        }
        System.out.printf(ADD_MESSAGE, category);
    }
    public static void printDeleteMessage(String category) {
        if (!category.equals(SECTION)) {
            category = SUBWAY + category;
        }
        System.out.printf(DELETE_MESSAGE, category);
    }

    public static void printStationList(String category) {
        System.out.printf(PRINT_LIST_MESSAGE, category);
        StationRepository.stations().stream()
                .map(Station::getName)
                .forEach(name -> System.out.printf(PRINT_LIST, name.getName()));
    }

    public static void printLineList(String category) {
        System.out.printf(PRINT_LIST_MESSAGE, category);
        LineRepository.lines().stream()
                .map(Line::getName)
                .forEach(name -> System.out.printf(PRINT_LIST, name.getName()));
    }

    public static void printSubwayMap() {
        System.out.println(PRINT_SUBWAY_MAP_MESSAGE);
        List<Line> lines = LineRepository.lines();
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            System.out.printf(PRINT_LIST, line.getName().getName());
            System.out.printf(PRINT_LIST, DASH);
            line.getStations().stream()
                    .map(Station::getName)
                    .forEach(name -> System.out.printf(PRINT_LIST, name.getName()));
            if (i != lines.size() - 1) {
                System.out.println();
            }
        }
    }
}
