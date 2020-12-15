package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.exception.CannotFindLineByNameException;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    private LineRepository() {
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void addSection(String lineName, int index, Station station) {
        List<Station> list = findByName(lineName).getSections();
        list.add(index, station);
    }

    public static boolean deleteLine(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line findByName(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new CannotFindLineByNameException(name));
    }

    public static boolean exists(String name) {
        return lines.stream()
                .anyMatch(line -> line.getName().equals(name));
    }

    public static boolean isStationRegisteredInAnyLine(String stationName) {
        return LineRepository.lines().stream()
                .anyMatch(line -> line.getSections()
                        .contains(StationRepository.findByName(stationName)));
    }

    public static void deleteAll() {
        lines.clear();
    }
}
