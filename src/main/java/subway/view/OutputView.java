package subway.view;

import subway.domain.line.model.Line;
import subway.domain.station.model.Station;

import java.util.List;

public class OutputView {
    private static final String INFO_MESSAGE = "[INFO] ";
    private static final String RESULT_VIEW_DIVIDER = "---";
    public static final String SUBWAY_ROUTE_MAP_MESSAGE = "## 지하철 노선도";

    public static void printLines(List<Line> lines) {
        System.out.println(SUBWAY_ROUTE_MAP_MESSAGE);
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
}
