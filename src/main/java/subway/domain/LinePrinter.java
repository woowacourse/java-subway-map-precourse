package subway.domain;

import subway.domain.repositories.LineRepository;

import java.util.List;

public class LinePrinter {
    private static final String HEADER = "## 지하철 노선도";
    private static final String INFO_HEADER = "[INFO] ";
    private static final String SEPARATOR = "---";

    public static void LinePrinterRun() {
        System.out.println(HEADER);
        List<Line> lineList = LineRepository.lines();
        for (Line line : lineList) {
            System.out.println(INFO_HEADER + line.getName());
            System.out.println(INFO_HEADER + SEPARATOR);
            printStationsByLineName(line.getName());
        }
    }

    private static void printStationsByLineName(String lineName) {
        List<String> stations = LineRepository.getStationsByLineName(lineName);
        for(String stationName : stations){
            System.out.println(INFO_HEADER + stationName);
        }
        System.out.println();
    }
}
