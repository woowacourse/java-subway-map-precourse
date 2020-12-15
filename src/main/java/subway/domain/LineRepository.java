package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    public static final String ERROR_MSG_NON_EXISTING_LINE = "[ERROR] 존재하지 않는 노선입니다.";

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean hasLine(String newLine) {
        for (Line line : lines) {
            if (line.getName().equals(newLine)) {
                return true;
            }
        }
        return false;
    }

    public static Line searchLineByName(String name) {
        return  lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(ERROR_MSG_NON_EXISTING_LINE);
                });
    }

    public static boolean isStationInSection(String name) {
        for (Line line : lines) {
            if (line.hasStation(name)) {
                return true;
            }
        }
        return false;
    }

    public static void printLineList() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n[INFO] 노선 목록\n");
        for (Line line : lines) {
            sb.append("[INFO] ");
            sb.append(line.getName());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
