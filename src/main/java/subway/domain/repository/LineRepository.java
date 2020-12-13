package subway.domain.repository;

import subway.domain.entity.Line;

import java.util.Collections;
import java.util.List;

public class LineRepository {

    private final List<Line> lines;

    public LineRepository(List<Line> lines) {
        this.lines = lines;
    }

    public void save(Line line) {
        lines.add(line);
    }

    public List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }
}
