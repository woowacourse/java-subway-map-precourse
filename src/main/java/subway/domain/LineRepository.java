package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(Name name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static List<String> getLineNames() {
        return lines.stream()
                .map(Line::toString)
                .collect(Collectors.toList());
    }

    public static Line getLineByName(Name name) {
        return lines.stream()
                .filter(line -> line.isName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 노선입니다."));
    }
}
