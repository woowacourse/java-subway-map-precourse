package subway.domain.line;

import java.util.List;

public interface LineRepository {
    List<Line> lines();

    Line addLine(Line line);

    Line findByName(String name);

    boolean deleteLineByName(String name);
}
