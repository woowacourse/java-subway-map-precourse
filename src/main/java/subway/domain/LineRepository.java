package subway.domain;

import static subway.resource.TextResource.ERROR_LINE_NAME_DUPLICATED;

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
        if (!hasLine(line.getName())) {
            lines.add(line);
            return;
        }
        throw new IllegalArgumentException(ERROR_LINE_NAME_DUPLICATED);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Boolean hasLine(String stationName) {
        for (Line station : lines) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }
}
