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
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void printLineList() {
        if (lines.size() == 0) {
            System.out.println("존재하는 노선이 없습니다.");
            return;
        }
        for (Line line : lines) {
            System.out.println(line.getName());
        }
    }

}
