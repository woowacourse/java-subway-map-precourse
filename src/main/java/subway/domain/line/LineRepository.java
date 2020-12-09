package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.line.exception.CannotFindLineByNameException;
import subway.domain.line.exception.DuplicateLineNameException;
import subway.domain.station.Station;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static Line findLineByName(String name) {
        return lines.stream()
            .filter(line -> line.getName().equals(name))
            .findAny()
            .orElseThrow(() -> {
                throw new CannotFindLineByNameException(name);
            });
    }

    public static void addLine(Line line) {
        if (lines.contains(line)) {
            throw new DuplicateLineNameException(line.getName());
        }

        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static boolean contains(Station targetStation) {
        return lines.stream()
            .anyMatch(line -> line.contains(targetStation));
    }

    public static void addSection(String lineName, int indexToInsert, Station station) {
        Line line = findLineByName(lineName);
        line.addSection(indexToInsert, station);
    }
}
