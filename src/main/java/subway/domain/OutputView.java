package subway.domain;

import java.util.List;

public class OutputView {
    private final String INFO_PREFIX = "[INFO] ";
    private final String ERROR_PREFIX = "[ERROR] ";
    private final String ENTIRE_SUBWAY_LINE_HEADER = "## 지하철 노선도";
    private final String DASH = "---";
    public OutputView() {
    }

    public void printEntireSubwayLine(List<Line> lineList) {
        printLine(ENTIRE_SUBWAY_LINE_HEADER);
        for (Line line : lineList) {
            printSubwayLine(line);
            printLine("");
        }
    }

    private void printSubwayLine(Line line) {
        printSubwayLineName(line);
        printInfo(DASH);
        printSubwayLineStations(line);
    }

    private void printSubwayLineName(Line line) {
        printInfo(line.getName());
    }

    private void printSubwayLineStations(Line line) {
        for (Station station : line.getStations()) {
            printInfo(station.getName());
        }
    }

    public void printLine(String message) {
        System.out.println(message);
    }

    public void printInfo(String message) {
        System.out.println(INFO_PREFIX + message);
    }

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

}
