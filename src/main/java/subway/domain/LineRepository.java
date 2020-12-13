package subway.domain;

import static subway.resource.TextResource.ERROR_LINE_NAME_DUPLICATED;
import static subway.resource.TextResource.ERROR_LINE_NOT_EXISTENCE;

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
        if (hasLine(name)) {
            return lines.removeIf(line -> Objects.equals(line.getName(), name));
        }
        throw new IllegalArgumentException(ERROR_LINE_NOT_EXISTENCE);
    }

    public static Boolean hasLine(String stationName) {
        for (Line station : lines) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }

    public static Line getLineByName(String name) {
        if (hasLine(name)) {
            throw new IllegalArgumentException(ERROR_LINE_NOT_EXISTENCE);
        }
        for (Line line : lines()) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        return null;
    }

    public static Boolean hasStationInLine(String stationName) {
        for (Line line : lines()) {
            Sections sections = line.getSections();
            if (sections.hasStationInSection(stationName)) {
                return true;
            }
        }
        return false;
    }
}
