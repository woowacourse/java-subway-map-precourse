package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        validate(line);
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    private static void validate(Line line) {
        validateLineNameRange(line);
        validateDuplicationLine(line);
    }

    private static void validateLineNameRange(Line line) {
        if (line.getName().length() < 2) {
            throw new IllegalArgumentException("[ERROR] 지하철 노선은 두 글자 이상이어야 합니다.");
        }
    }

    private static void validateDuplicationLine(Line line) {
        if (lines().contains(line)) {
            throw new IllegalArgumentException("[ERROR] 지하철 노선은 중복될 수 없습니다.");
        }
    }
}
