package subway.line.domain;

import subway.line.exception.NotExistLineException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }

    public static void register(Line line) {
        lines.add(line);
    }

    public static void remove(Line line) {
        lines.remove(line);
    }

    public static Line findByName(String name) {
        return findAll().stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .orElseThrow(NotExistLineException::new);
    }

    public static boolean isExist(String name) {
        return findAll().stream()
                .anyMatch(line -> line.getName().equals(name));
    }

    public static void removeAll() {
        lines.clear();
    }
}
