package subway.repository.line;

import subway.domain.line.Line;
import subway.domain.line.LineName;

import java.util.List;

public interface LineRepository {
    List<Line> lines();
    void addLine(Line line);
    boolean deleteLineByName(LineName name);
    Line findLineByName(LineName name);
}
