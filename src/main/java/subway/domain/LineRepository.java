package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

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
    
    public static void addSectionToLine(String lineName, String stationName, String order) {
        filterEqualNameLine(lineName).findAny()
                                     .ifPresent(line -> line.addSection(stationName, order));
    }

    public static void deleteSectionFromLine(String lineName, String stationName) {
        filterEqualNameLine(lineName).findAny()
                                     .ifPresent(line -> line.deleteSection(stationName));
    }

    public static boolean isExistedLine(String name) {
        return lines.stream()
                    .anyMatch(line -> line.isEqualName(name));
    }

    public static boolean hasStation(String stationName) {
        return lines.stream()
                    .anyMatch(line -> line.isStation(stationName));
    }

    public static boolean hasSection(String lineName, String stationName) {
        return filterEqualNameLine(lineName).anyMatch(line -> line.isStation(stationName));
    }

    public static boolean isBiggerLineSizeThan(String lineName, int number) {
        return filterEqualNameLine(lineName).anyMatch(line -> line.isBiggerThan(number));
    }
    
    private static Stream<Line> filterEqualNameLine(String lineName) {
        return lines.stream()
                    .filter(line -> line.isEqualName(lineName));
    }
}
