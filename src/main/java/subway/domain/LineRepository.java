package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String INFO = "[INFO] ";
    private static final String INFO_WITH_BORDER = "[INFO] ---";

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        // TODO 노선 이름 중복 확인할 것
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void printMap() {
        for(Line line : lines) {
            System.out.println(INFO + line.getName());
            System.out.println(INFO_WITH_BORDER);
            line.printStations();
        }
    }
}
