package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> retrieveLine() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(String lineName, String firstStation, String lastStation) {
        lines.add(new Line(lineName, firstStation, lastStation));
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void addSection(int idx, String line, String name) {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).getName().equals(line)) {
                lines.get(i).addStationInSection(idx, name);
                return;
            }
        }
    }

    public static void deleteSection(String line, String name) {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).getName().equals(line)) {
                lines.get(i).deleteStationInSection(name);
            }
        }
    }
}
