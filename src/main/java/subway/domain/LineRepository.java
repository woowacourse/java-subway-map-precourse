package subway.domain;

import subway.enums.InitialSetting;

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

    public static boolean isNameDuplication(String name) {
        return lines.stream()
                .map(Line::getName)
                .anyMatch(line -> line.equals(name));
    }

    public static boolean isNameLengthUnder2(String name) {
        return name.trim().length() < 2;
    }

    public static Line getLineByName(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .get();
    }

    public static void initializeLines() {
        InitialSetting.LINES.getValues()
                .stream()
                .map(Line::new)
                .forEach(LineRepository::addLine);
    }
}
