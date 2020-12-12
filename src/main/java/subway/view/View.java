package subway.view;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;

public class View {

    private static final String PRINT_NOTICE = "## ";
    private static final String PRINT_INFO = "[INFO] ";

    public static void printSubwayMap(List<Line> lines) {
        lines.stream().forEach(line -> printLineMap(line));
        System.out.println();
    }

    private static void printLineMap(Line line) {
        System.out.println(PRINT_INFO + line.getName());
        System.out.println(PRINT_INFO + "---");
        line.getStations().stream()
            .forEach(station -> System.out.println(PRINT_INFO + station.getName()));
    }

    public static void printAllStations(List<Station> stations) {
        System.out.println(PRINT_NOTICE + "역 목록");
        stations.stream().forEach(station -> System.out.println(PRINT_INFO + station.getName()));
    }
}
