package subway.repository.line;

import subway.domain.Line.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepositoryImpl implements subway.domain.repository.line.LineRepository {
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
    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
