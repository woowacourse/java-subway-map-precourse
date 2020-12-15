package subway.repository;

import static subway.console.message.ErrorMessage.EMPTY_LINE;
import static subway.console.message.ErrorMessage.EXIST_LINE;
import static subway.console.message.ErrorMessage.NOT_EXIST_LINE;
import static subway.console.message.ErrorMessage.SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.Line;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LINE.getMessage());
        }
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        validateExistLine(line);
        lines.add(line);
    }

    private static void validateExistLine(Line line) {
        if (lines.contains(line)) {
            throw new IllegalArgumentException(EXIST_LINE.getMessage());
        }
    }

    public static boolean deleteLine(Line line) {
        validateEmptyLines();
        return lines.remove(line);
    }

    private static void validateEmptyLines() {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(SIZE.getMessage());
        }
    }

    public static Line findLineByName(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_LINE.getMessage()));
    }
}
