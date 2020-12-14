package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String LINE_NAME_LENGTH_ERROR = "이름이 2글자 미만입니다.";
    private static final String LINE_NAME_DUPLICATE_ERROR = "기존의 역과 중복됩니다.";
    
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        if(!line.isValidName()) {
            throw new IllegalArgumentException(LINE_NAME_LENGTH_ERROR);
        }
        if (lines.contains(line)) {
            throw new IllegalArgumentException(LINE_NAME_DUPLICATE_ERROR);
        }
        lines.add(line);
    }
    
    public static void addSection(Line line, Station station, int order) {
        line.addStation(station, order);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
    
    public static boolean deleteSection(Line line, Station station) {
        return line.deleteStation(station);
    }
    
    public static boolean isStationExistOnLines(String name) {
        for (Line line : lines) {
            if (line.hasStation(name)) {
                return true;
            }
        }
        return false;
    }
}
