package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import subway.utils.Validator;

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

    public static boolean hasLine(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Line> getAllLines() {
        return (ArrayList<Line>) lines;
    }

    public static Line getLine(String name) {
        Validator.checkRegisteredLine(name);
        return lines.stream()
            .filter(l -> l.getName().equals(name))
            .findAny()
            .orElseThrow();
    }
}
