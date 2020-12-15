package subway.repository;

import subway.domain.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * LineRepository.java : 지하철 노선에 대한 저장소 클래스
 */
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

    public static List<String> lineNames() {
        List<String> lineNames = new ArrayList<>();

        for (Line line : lines) {
            lineNames.add(line.getName());
        }
        return lineNames;
    }
}
