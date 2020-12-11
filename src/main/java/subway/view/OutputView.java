package subway.view;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class OutputView {
    private static final String PRINT_STATION_LIST_MESSAGE = "## 역 목록";
    private static final String PRINT_LINE_LIST_MESSAGE = "## 노선 목록";
    private static final String PRINT_LIST = "[INFO] %s\n";

    private OutputView() {
    }

    public static void printStationList() {
        System.out.println(PRINT_STATION_LIST_MESSAGE);
        StationRepository.stations().stream()
                .map(Station::getName)
                .forEach(name -> System.out.printf(PRINT_LIST, name));
    }

    public static void printLineList() {
        System.out.println(PRINT_LINE_LIST_MESSAGE);
        LineRepository.lines().stream()
                .map(Line::getName)
                .forEach(name -> System.out.printf(PRINT_LIST, name));
    }

}
