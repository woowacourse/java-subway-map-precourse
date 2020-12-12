package subway.repository;

import subway.domain.Line;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isStationExistInLine(Station station) {
        return lines.stream()
                .anyMatch(line -> line.getStationList()
                        .stream()
                        .anyMatch(Predicate.isEqual(station)));
    }
}