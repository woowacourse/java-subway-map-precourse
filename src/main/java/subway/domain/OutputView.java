package subway.domain;

import java.util.List;

public class OutputView {
    private final String INFO_PREFIX = "[INFO] ";
    private final String ERROR_PREFIX = "[ERROR] ";
    private final String ENTIRE_SUBWAY_LINE_HEADER = "## 지하철 노선도";
    private final String STATION_LIST_HEADER = "## 역 목록";
    private final String DASH = "---";
    public OutputView() {
    }

    public void printStationList(List<Station> stationList) {
        printLine(STATION_LIST_HEADER);
        printStationNames(stationList);
        printLine("");
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
        printStationNames(line.getStations());
    }

    private void printSubwayLineName(Line line) {
        printInfo(line.getName());
    }

    private void printStationNames(List<Station> stationList) {
        for (Station station : stationList) {
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
