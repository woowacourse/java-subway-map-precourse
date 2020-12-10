package subway.line;

import subway.domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LineRepositoryJava implements LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    @Override
    public List<Line> lines() {
        return new ArrayList<>(lines);
    }

    @Override
    public void addLine(Line line) {
        lines.add(line);
    }

    @Override
    public void deleteLine(Line line) {
        lines.remove(line);
    }

    @Override
    public Optional<Line> findByName(String name) {
        return lines.stream()
                .filter(line -> Objects.equals(line.getName(), name))
                .findAny();
    }


}
