package subway.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LineRepository {

    private static final Set<Line> lines = new HashSet<>();

    public void addLine(Line line) {
        lines.add(line);
    }

    public static Set<Line> findAll() {
        return Collections.unmodifiableSet(lines);
    }

    public Line findByName(String line) {
        for (Line lineElement : lines) {
            if (lineElement.getName().equals(line)) {
                return lineElement;
            }
        }
        return null;
    }

    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

}
