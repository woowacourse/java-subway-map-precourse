package subway.line.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.line.exception.CannotFindLineByNameException;
import subway.line.exception.DuplicateLineNameException;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }

    public static Line findByName(String name) {
        return lines.stream()
            .filter(line -> line.getName().equals(name))
            .findAny()
            .orElseThrow(() -> {
                throw new CannotFindLineByNameException(name);
            });
    }

    public static void save(Line line) {
        if (lines.contains(line)) {
            throw new DuplicateLineNameException(line.getName());
        }

        lines.add(line);
    }

    public static void saveAll(List<Line> lines) {
        lines.forEach(LineRepository::save);
    }

    public static void delete(Line line) {
        lines.remove(line);
    }

    public static void deleteAll() {
        lines.clear();
    }
}
