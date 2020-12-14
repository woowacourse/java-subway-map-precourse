package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.constant.BoundaryCheckDigit;

public class LineRepository {

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

    public static Line getLineByName(String name) {
        return lines.stream()
            .filter(line -> line.getName().equals(name))
            .collect(Collectors.toList())
            .get(BoundaryCheckDigit.LIST_GET_FIRST.getBoundaryCheckDigit());
    }

    public static List<String> getAllLineNames() {
        return LineRepository
            .lines()
            .stream()
            .map(Line::getName)
            .collect(Collectors.toList());
    }
}
