package subway.domain;

import subway.exception.DomainIsNotExistedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = Arrays.asList(new Line("2호선"), new Line("3호선"), new Line("신분당선"));

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
}
