package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();
    private static final int VALID_MIN_SIZE_OF_LINE_STATIONS = 2;

    static {
        lines.add(new Line("2호선", new ArrayList<Station>(Arrays.asList(
            new Station("교대역"),
            new Station("강남역"),
            new Station("역삼역"))
        )));
        lines.add(new Line("3호선", new ArrayList<Station>(Arrays.asList(
            new Station("교대역"),
            new Station("남부터미널역"),
            new Station("양재역"),
            new Station("매봉역"))
        )));
        lines.add(new Line("신분당선", new ArrayList<Station>(Arrays.asList(
            new Station("강남역"),
            new Station("양재역"),
            new Station("양재시민의숲역"))
        )));
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        validateOverlappedLineName(line.getName());
        lines.add(line);
    }

    private static void validateOverlappedLineName(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                throw new IllegalArgumentException("[ERROR] 중복된 지하철 노선 이름은 등록될 수 없습니다.");
            }
        }
        return;
    }

    public static Line findByName(String name) {
        return lines.stream()
            .filter(line -> line.getName().equals(name))
            .findFirst()
            .get();
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    private static void validateStationsSizeInLineToDelete(String name) {
        Line lineToDelete = lines.stream()
            .filter(line -> line.getName().equals(name))
            .findFirst()
            .get();
        if (lineToDelete.getStations().size() <= VALID_MIN_SIZE_OF_LINE_STATIONS) {
            throw new IllegalArgumentException("[ERROR] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.");
        }
    }

    public static boolean contains(String stationName) {
        for (Line line : lines) {
            if (line.contains(stationName)) {
                return true;
            }
        }
        return false;
    }

    public static void addStation(String lineName, String stationName, int order) {
        Line line = findByName(lineName);
        line.addStation(stationName, order);
    }

    public static void deleteStation(String lineName, String stationName) {
        Line line = findByName(lineName);
        line.deleteStation(stationName);
    }
}
