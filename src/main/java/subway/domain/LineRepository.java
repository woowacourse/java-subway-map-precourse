 package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.exception.CannotFindLineByNameException;
import subway.exception.LineAlreadyExistsException;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    private LineRepository() {
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        validateDuplicated(line);
        lines.add(line);
    }

    private static void validateDuplicated(Line line) {
        if (exists(line.getName())) {
            throw new LineAlreadyExistsException(line.getName());
        }
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

    public static void deleteAll() {
        lines.clear();
    }

}
