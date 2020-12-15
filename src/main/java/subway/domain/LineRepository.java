package subway.domain;

import subway.exception.DomainIsNotExistedException;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>(Arrays.asList(new Line("2호선"), new Line("3호선"), new Line("신분당선")));

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static Line getLine(String name) throws DomainIsNotExistedException {
        return lines
                .stream()
                .filter(line -> Objects.equals(line.getName(), name))
                .findAny()
                .orElseThrow(DomainIsNotExistedException::new);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isContainedLineName(String name) {
        return lines.stream().anyMatch(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isContainedStationInLines(String name) {
        return lines().stream().anyMatch(line ->
                line.stations().stream().anyMatch(station -> Objects.equals(station.getName(), name)));
    }
}
