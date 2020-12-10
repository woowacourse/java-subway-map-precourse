package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    public static final String DUPLICATE_NAME_ERROR = "%s은 이미 존재하는 노선 이름입니다!";

    public static final String DOES_NOT_EXIST_ERROR = "%s은 존재하지 않습니다.";

    private final List<Line> lines;

    public LineRepository() {
        this.lines = new LinkedList<>();
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public void addLine(Line line) {
        if (lines.contains(line)) {
            throw new IllegalArgumentException(String.format(DUPLICATE_NAME_ERROR, line.getName()));
        }

        lines.add(line);
    }

    public void deleteLineByName(String name) {
        if (!lines.removeIf(line -> Objects.equals(line.getName(), name))) {
            throw new IllegalArgumentException(String.format(DOES_NOT_EXIST_ERROR, name));
        }
    }

    public boolean contains(String stationName) {
        return lines.stream().anyMatch(line -> line.contains(stationName));
    }
}
