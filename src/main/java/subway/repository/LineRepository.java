package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.console.Message;
import subway.domain.Line;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        validateEmptyLines();
        validateExistLines(name);
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    private static void validateEmptyLines() {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(Message.ERROR_SIZE);
        }
    }

    private static void validateExistLines(String name) {
        if (!isExist(name)) {
            throw new IllegalArgumentException(Message.ERROR_NOT_EXIST_LINE);
        }
    }

    public static Line findOne(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static boolean isExist(String name) {
        return lines.stream().anyMatch(station -> station.getName().equals(name));
    }
}
