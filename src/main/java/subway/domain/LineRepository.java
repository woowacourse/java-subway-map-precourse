package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final int ZERO_NUMBER = 0;
    private static final String OVERLAP_ERROR = "[ERROR] 노선의 이름이 중복이 되었습니다.";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        checkOverlappedLine(line);
        lines.add(line);
        Collections.sort(lines);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    private static void checkOverlappedLine(Line target) {
        long isOverlap = lines.stream()
                .filter(line -> line.compareName(target.getName()))
                .count();
        if (isOverlap != ZERO_NUMBER) {
            throw new IllegalArgumentException(OVERLAP_ERROR);
        }
    }
}
