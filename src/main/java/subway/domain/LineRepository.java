package subway.domain;

import subway.enums.Criteria;
import subway.enums.InitialLines;

import java.util.*;

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

    public static boolean isNameDuplication(String name) {
        return lines.stream()
                .map(Line::getName)
                .anyMatch(line -> line.equals(name));
    }

    public static boolean isNameLengthUnder2(String name) {
        return name.trim().length() < Criteria.MINIMUM_NAME_LENGTH.getValue();
    }

    public static Line getLineByName(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .get();
    }

    public static void initializeLines() {
        Arrays.stream(InitialLines.values())
                .map(InitialLines::getName)
                .map(Line::new)
                .forEach(LineRepository::addLine);;
    }
}
