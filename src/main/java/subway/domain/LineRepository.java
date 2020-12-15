package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line, List<String> names) {
        for (int i = 1; i <= names.size(); i++)
            line.addStation(i, names.get(i-1));
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isExist(String name) {
        return lines.stream().map(Line::getName).anyMatch(x -> x.equals(name));
    }

    public static Line getLineByName(String Name) {
        return lines.stream().filter(line -> line.getName().equals(Name)).findAny().orElse(null);
    }

    public static void addStationToLine(String lineName, String stationName, int index) {
        Line line = getLineByName(lineName);
        line.addStation(index, stationName);
    }
}
