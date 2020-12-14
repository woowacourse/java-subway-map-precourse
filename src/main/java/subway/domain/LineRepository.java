package subway.domain;

import subway.view.OutputView;

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
        if (!hasDuplicatedLine(line)) {
            lines.add(line);
            return;
        }
        OutputView.printDuplicatedErrorMessage(line.toString());
    }

    public static void addLines(List<Line> lines) {
        lines.forEach(LineRepository::addLine);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean hasDuplicatedLine(Line line) {
        return lines.contains(line);
    }
}
