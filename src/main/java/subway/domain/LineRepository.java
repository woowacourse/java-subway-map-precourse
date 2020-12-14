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

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean containsStation(String name) {
        return lines.stream().anyMatch(line -> line.getStations().stream()
            .anyMatch(station -> station.getName().equals(name)));
    }

    public static boolean contains(String name) {
        return lines.stream().anyMatch(line -> line.getName().equals(name));
    }

    public static boolean lineContainsStation(String lineName, String stationName) {
        return findByLineName(lineName).getStations().stream()
            .anyMatch(station -> station.getName().equals(stationName));
    }

    public static Line findByLineName(String lineName) {
        return lines.stream().filter(line -> line.getName().equals(lineName)).findFirst().get();
    }

    public static int getSectionLength(String lineName) {
        return lines.stream().filter(line -> line.getName().equals(lineName)).findFirst().get()
            .getStations().size();
    }
}
