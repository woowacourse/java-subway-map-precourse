package subway.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LineRepository {

    private final Set<Line> lines = new HashSet<>();

    public void addLine(Line line) {
        lines.add(line);
    }

    public Set<Line> findAll() {
        return Collections.unmodifiableSet(lines);
    }

    public Line findByName(String name) {
        return lines.stream()
            .filter(line -> line.getName().equals(name))
            .findFirst()
            .orElse(null);
    }

    public boolean isExistByName(String name) {
        return findByName(name) != null;
    }

    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
