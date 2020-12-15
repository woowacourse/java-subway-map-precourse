package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.console.message.ErrorMessage;
import subway.domain.Line;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_LINE);
        }
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        validateExistLine(line);
        lines.add(line);
    }

    private static void validateExistLine(Line line) {
        if (lines.contains(line)) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_LINE);
        }
    }

    public static boolean deleteLine(Line line) {
        validateEmptyLines();
        return lines.remove(line);
    }

    private static void validateEmptyLines() {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.SIZE);
        }
    }

    public static Line findLineByName(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_LINE));
    }
}
