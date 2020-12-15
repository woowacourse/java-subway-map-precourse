package subway.repository.line;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.exception.line.LineNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepositoryImpl implements LineRepository {
    private final List<Line> lines = new ArrayList<>();

    @Override
    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public void addLine(Line line) {
        lines.add(line);
    }

    @Override
    public boolean deleteLineByName(LineName name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    @Override
    public Line findLineByName(LineName name) {
        return lines.stream()
                .filter(line -> Objects.equals(line.getName(), name))
                .findAny()
                .orElseThrow(() -> new LineNotFoundException());
    }
}
