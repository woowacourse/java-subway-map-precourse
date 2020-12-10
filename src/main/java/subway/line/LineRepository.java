package subway.line;

import subway.domain.Line;

import java.util.List;
import java.util.Optional;

public interface LineRepository {
    List<Line> lines();

    void addLine(Line line);

    void deleteLine(Line line);

    Optional<Line> findByName(String name);
}
