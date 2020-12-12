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

    public static void addLine(String lineName, String upboundStationName,
            String downboundStationName) {
        lines.add(new Line(lineName, upboundStationName, downboundStationName));
    }

    public static void addSection(String lineName, String stationName, String index) {
        getLineByName(lineName).addSection(stationName, index);
    }

    public static void deleteLineByName(String name) {
        getLineByName(name).removeAllSections();
        lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteStationInLine(String stationName, String lineName) {
        getLineByName(lineName).removeSection(stationName);
    }

    public static boolean hasLine(String name) {
        return lines.stream().filter(line -> Objects.equals(line.getName(), name)).count() > 0;
    }

    public static int getNumberOfStationInLine(String lineName) {
        Line line = getLineByName(lineName);
        return line.getNumberOfSections();
    }

    public static boolean isStationInLine(String stationName, String lineName) {
        Line line = getLineByName(lineName);
        return line.hasStation(stationName);
    }

    public static boolean isValidRangeInLine(int index, String lineName) {
        Line line = getLineByName(lineName);
        return line.isValidRange(index);
    }

    public static boolean isEmpty() {
        return lines.isEmpty();
    }

    private static Line getLineByName(String name) {
        return lines.stream().filter(line -> Objects.equals(line.getName(), name)).findFirst()
                .get();
    }
}
