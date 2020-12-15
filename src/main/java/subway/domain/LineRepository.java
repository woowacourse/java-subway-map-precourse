package subway.domain;

import subway.Exception.LineException.CanNotFindLineException;

import java.util.*;

public class LineRepository {
    private static final String NEW_LINE = "\n";
    private static final String PRINT_INFO = "[INFO] ";
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

    public static Line findByName(String name) {
        return lines().stream()
                .filter(line -> line.getName().equals(name))
                .findAny()
                .orElseThrow(CanNotFindLineException::new);
    }

    public static boolean contains(String name) { // 이미 존재하는 노선인지 확인, 유효성 검사
        return lines().stream()
                .anyMatch(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isValidLineNameLength(String name) {
        return name.length() < Line.MIN_LINE_NAME_LENGTH;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines()) {
            sb.append(PRINT_INFO + line + NEW_LINE);
        }
        return sb.toString();
    }
}
