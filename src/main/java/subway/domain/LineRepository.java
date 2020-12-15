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

//    public static void deleteStationsOnLineByName(String name) {
//        for (Line line : lines) {
//            line.getStations().removeIf(station -> Objects.equals(station.getName(), name));
//        }
//    }

    public static Line getLineByName(String lineName) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(lineName)) {
                return line;
            }
        }
        return null;
    }
}
