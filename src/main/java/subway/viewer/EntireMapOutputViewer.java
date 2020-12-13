package subway.viewer;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

public class EntireMapOutputViewer {
    private static final String DASH_LINE = "---";
    private static final String INFO_MESSAGE = "[INFO] %s\n";
    private static final String SUBWAY_MAP = "## 지하철 노선도";

    public static void showEntireMap(List<Line> lines) {
        System.out.println(SUBWAY_MAP);
        for (Line line : lines) {
            System.out.printf(INFO_MESSAGE, line.getName());
            System.out.printf(INFO_MESSAGE, DASH_LINE);
            showStationUnderLine(line);
            System.out.println();
        }
    }

    private static void showStationUnderLine(Line line) {
        for (Station station : line.getStations()) {
            System.out.printf(INFO_MESSAGE, station.getName());
        }
    }
}
