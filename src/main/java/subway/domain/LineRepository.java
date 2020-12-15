package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final int EMPTY_LINES = 0;

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        validateNameDuplicate(line);
        lines.add(line);
    }

    public static void deleteLine(String name) {
        if (!lines.removeIf(line -> Objects.equals(line.getName(), name))) {
            throw new IllegalArgumentException("일치하는 지하철 노선이 없습니다.");
        }
    }

    public static void validateNameDuplicate(Line line) {
        if (lines.stream()
            .anyMatch(thisLine -> thisLine.getName().equals(line.getName()))) {
            throw new IllegalArgumentException("동일한 지하철 노선 이름이 존재합니다.");
        }
    }

    public static void validateLinesEmpty() {
        if (lines.size() == EMPTY_LINES) {
            throw new IllegalArgumentException("등록 되어 있는 지하철 노선이 없습니다.");
        }
    }
}
