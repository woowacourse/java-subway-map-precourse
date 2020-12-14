package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.utils.LineRepositoryValidator;
import subway.view.ErrorView;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        LineRepositoryValidator.validateAddition(line);
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        LineRepositoryValidator.validateDeletion(name);
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean hasLineWithStation(String name) {
        return lines().stream()
                .anyMatch(line -> line.hasStation(name));
    }

    public static Line get(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorView.LINE_NOTHING));
    }

    public static boolean hasLine(Line line) {
        return lines().contains(line);
    }
}
