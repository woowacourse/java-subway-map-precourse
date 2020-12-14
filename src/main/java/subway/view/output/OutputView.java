package subway.view.output;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.view.utils.Formatter;

import java.util.List;

public class OutputView {
    private static final String PRINT_STATION_HEADER = "## 역 목록";
    private static final String PRINT_LINE_HEADER = "## 노선 목록";

    public static void printStationList(List<Station> list) {
        System.out.println(PRINT_STATION_HEADER);

        list.stream()
                .map(Station::getName)
                .map(StationName::toString)
                .map(Formatter::Info)
                .forEach(System.out::println);

        System.out.println();
    }

    public static void printLineList(List<Line> list) {
        System.out.println(PRINT_LINE_HEADER);

        list.stream()
                .map(Line::getName)
                .map(LineName::toString)
                .map(Formatter::Info)
                .forEach(System.out::println);

        System.out.println();
    }
}
