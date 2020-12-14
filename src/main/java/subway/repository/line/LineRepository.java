package subway.repository.line;

import subway.domain.Line.Line;

import java.util.List;

public interface LineRepository {
    List<Line> lines();
    void addLine(Line line);
    boolean deleteLineByName(String name);
}
