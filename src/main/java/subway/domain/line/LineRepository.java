package subway.domain.line;

import java.util.*;

public class LineRepository {
    private static final String LINE_DUPLICATE_ERROR = "\n[ERROR] 이미 등록되어 있는 노선입니다.";
    private static final String LINE_EXIST_ERROR = "\n[ERROR] 등록되어 있는 노선이 아닙니다.";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void validateDuplicate(LineName lineName) {
        if (lines.contains(Line.of(lineName))) {
            throw new IllegalArgumentException(LINE_DUPLICATE_ERROR);
        }
    }

    public static boolean deleteLineByName(LineName lineName) {
        validateNameExist(lineName);
        return lines.removeIf(line -> Objects.equals(line.getName(), lineName));
    }

    public static void validateNameExist(LineName lineName) {
        if (!lines.contains(Line.of(lineName))) {
            throw new IllegalArgumentException(LINE_EXIST_ERROR);
        }
    }

    public static Line getLineByName(LineName lineName) {
        return lines.stream()
                .filter(line -> line.getName().equals(lineName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(LINE_EXIST_ERROR));
    }


}
