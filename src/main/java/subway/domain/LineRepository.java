package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import subway.exception.LineException;

public class LineRepository extends LineException {
    private static final List<Line> lines = new ArrayList<>();
    private static final int LINE_NAME_LENGTH_LIMIT = 2;
    private static final String SYMBOL_INFO = "[INFO] ";
    private static final String MAIN_SCREEN_PRINT_SUBWAY_MAP = "\n## 지하철 노선도";
    private static final int UP_DOWN_END_STATION_TOTAL = 2;
    private static final List<Station> stations = StationRepository.stations();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void initializeLine(String lineName, String upEndStationName,
            String downEndStationName) {
        Line newLine = new Line(lineName);
        Station upEndStations = stations.stream()
            .filter(station -> station.getName().equals(upEndStationName))
            .findAny().get();
        Station downEndStations = stations.stream()
            .filter(station -> station.getName().equals(downEndStationName))
            .findAny().get();
        newLine.initializeEndStations(upEndStations, downEndStations);
        addLine(newLine);
    }

    public static void validateEndStationNames(String upEndStationName, String downEndStationName) {
        if (upEndStationName.equals(downEndStationName)) {
            throw new SameStationNameException(upEndStationName);
        }
        if (!areInStationRepository(upEndStationName, downEndStationName)) {
            throw new IllegalArgumentException(ERROR_NOT_IN_STATION_REPOSITORY);
        }
    }

    private static boolean areInStationRepository(String upEndStationName, String downEndStationName) {
        Stream<Station> stationStream = StationRepository.stations().stream();
        return stationStream.filter(station ->
            station.getName().equals(upEndStationName) || station.getName().equals(downEndStationName))
            .count() == UP_DOWN_END_STATION_TOTAL;
    }

    public static void validateLineName(String lineName) {
        if (lineName.length() < LINE_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ERROR_INVALID_LINE_NAME_LENGTH);
        }
        Stream<Line> lineStream = lines().stream();
        if (lineStream.anyMatch(line -> line.getName().equals(lineName))) {
            throw new DuplicatedLineNameException(lineName);
        }
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void deleteLineByName(String lineName) {
        Line lineSelected = getLine(lineName);
        disEnrollStations(lineSelected); // 노선에 속한 역 등록 해제
        lines.remove(lineSelected);
    }

    private static void disEnrollStations(Line lineSelected) {
        Iterator iterator = lineSelected.stations().iterator();
        while (iterator.hasNext()) {
            Station station = (Station) iterator.next();
            station.disEnroll(lineSelected);
        }
    }

    public static void printSubwayMap() {
        Iterator iterator = lines().iterator();
        while (iterator.hasNext()) {
            Line line = (Line) iterator.next();
            System.out.println(SYMBOL_INFO + line.getName());
            line.printStations();
            System.out.println();
        }
    }

    public static void displayAllLines() {
        System.out.println(MAIN_SCREEN_PRINT_SUBWAY_MAP);
        Iterator iterator = lines().iterator();
        while (iterator.hasNext()) {
            Line line = (Line) iterator.next();
            System.out.println(SYMBOL_INFO + line.getName());
        }
        if (lines().size() == 0) {
            System.out.println(EMPTY_LINE_REPOSITORY);
        }
    }

    public static Line getLine(String lineName) {
        try {
            return lines().stream()
                .filter(line -> line.getName().equals(lineName))
                .findFirst()
                .get();
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_NOT_FOUND_LINE_NAME);
        }
    }
}
