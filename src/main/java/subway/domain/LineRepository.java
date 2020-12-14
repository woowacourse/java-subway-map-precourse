package subway.domain;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final String NEW_LINE = "\n";
    private static final String PRINT_INFO = "[INFO] ";

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
         for (Line line : lines()) {
             if (line.getName().equals(name)) {
                 return line;
             }
         }
         return null;
    }

    public static boolean contains(String name) { // 이미 존재하는 노선인지 확인, 유효성 검사
        return lines().stream()
                .anyMatch(line -> Objects.equals(line.getName(), name));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines()) {
            sb.append(PRINT_INFO + line + NEW_LINE);
        }
        return sb.toString();
    }
}
