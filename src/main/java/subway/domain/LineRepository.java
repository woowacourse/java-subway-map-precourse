package subway.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class LineRepository {

    public static final String DUPLICATE_NAME_ERROR = "%s은 이미 존재하는 노선 이름입니다!";

    public static final String DOES_NOT_EXIST_ERROR = "%s은 존재하지 않습니다.";

    private final Set<Line> lines;

    public LineRepository() {
        this.lines = new LinkedHashSet<>();
    }

    public Set<Line> lines() {
        return Collections.unmodifiableSet(lines);
    }

    public void addLine(String name) {
        if (!lines.add(new Line(name))) {
            throw new IllegalArgumentException(String.format(DUPLICATE_NAME_ERROR, name));
        }
    }

    public void deleteLineByName(String name) {
        if (lines.removeIf(line -> Objects.equals(line.getName(), name))) {
            throw new IllegalArgumentException(String.format(DOES_NOT_EXIST_ERROR, name));
        }
    }
}
