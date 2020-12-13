package subway.domain.line;

import java.util.*;

public class LineRepository {
    private static String LINE_NOT_EXIST_ERROR = "\n[ERROR] 노선 목록에 등록되어 있는 노선이 아닙니다.";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean hasLine(LineName lineName) {
        return lines.stream()
                .map(Line::getName)
                .anyMatch(name -> name.equals(lineName));
    }

    public static boolean deleteLineByName(LineName lineName) {
        return lines.removeIf(line -> Objects.equals(line.getName(), lineName));
    }

    public static Line getLineByName(LineName lineName) {
        return lines.stream()
                .filter(line -> line.getName().equals(lineName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(LINE_NOT_EXIST_ERROR));
    }

}
