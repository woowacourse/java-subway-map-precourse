package subway.domain.line;

import java.util.List;

public interface LineRepository {
    List<Line> lines();

    void addLine(Line line);

    boolean deleteLineByName(String name);
}
