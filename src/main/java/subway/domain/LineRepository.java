package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String ERR_LINE_NOT_IN_REPO = "존재하지 않는 노선 이름입니다";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line getLine(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERR_LINE_NOT_IN_REPO));
    }

    public static boolean hasLineNamed(String name) {
        return lines.stream()
                .anyMatch(line -> line.getName().equals(name));
    }
}
