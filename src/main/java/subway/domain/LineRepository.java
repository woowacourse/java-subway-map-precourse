package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final int LINE_NAME_LENGTH_LIMIT = 2;
    private static final String ERROR_INVALID_LINE_NAME_LENGTH = "[ERROR] 노선 이름이 너무 짧습니다.";
    private static final String ERROR_DUPLICATED_LINE_NAME_IN_REPOSITORY = "[ERROR] 같은 노선 이름이 이미 있습니다.";
    private static final String ERROR_SAME_STATION_NAME = "[ERROR] 서로 다른 이름의 역을 입력해야 합니다.";
    private static final String ERROR_NOT_IN_STATION_REPOSITORY = "[ERROR] 기존 데이터에 없는 역이 입력됐습니다.";
    private static final String SYMBOL_INFO = "[INFO] ";
    private static final int UP_DOWN_END_STATION_TOTAL = 2;

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void initializeLine(String lineName, String upEndStationName, String downEndStationName) {
        validateLineName(lineName);
        Line newLine = new Line(lineName);

        validateEndStationNames(upEndStationName, downEndStationName);

        Stream<Station> stationStream = StationRepository.stations().stream();
        ArrayList<Station> bothEndStations = stationStream.filter(station -> station.getName().
            equals(upEndStationName) || station.getName().equals(downEndStationName)).
            collect(Collectors.toCollection(ArrayList<Station>::new));

        newLine.initializeEndStations(bothEndStations.get(0), bothEndStations.get(1));
        addLine(newLine);
    }

    private static void validateEndStationNames(String upEndStationName,
        String downEndStationName) {
        if (upEndStationName.equals(downEndStationName)) {
            throw new IllegalArgumentException(ERROR_SAME_STATION_NAME);
        }
        if (!areInStationRepository(upEndStationName, downEndStationName)) {
            throw new IllegalArgumentException(ERROR_NOT_IN_STATION_REPOSITORY);
        }
    }

    private static boolean areInStationRepository(String upEndStationName, String downEndStationName) {
        Stream<Station> stationStream = StationRepository.stations().stream();
        return stationStream.filter(station ->
            station.getName().equals(upEndStationName) ||
            station.getName().equals(downEndStationName)).count() == UP_DOWN_END_STATION_TOTAL;
    }

    private static void validateLineName(String lineName) {
        if (lineName.length() < LINE_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ERROR_INVALID_LINE_NAME_LENGTH);
        }
        Stream<Line> lineStream = lines.stream();
        if (lineStream.anyMatch(line -> line.getName().equals(lineName))) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_LINE_NAME_IN_REPOSITORY);
        }
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void printSubwayMap() {
    }

    public static void displayAllLines() {
        Iterator iterator = lines().iterator();
        while (iterator.hasNext()) {
            Line line = (Line)iterator.next();
            System.out.println(SYMBOL_INFO + line.getName());
        }
    }
}
