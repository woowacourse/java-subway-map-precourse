package subway.domain;

import subway.exception.LineEmptyException;
import subway.exception.LineNotExistException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static Line findLine(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        throw new LineNotExistException();
    }

    public static void deleteLine(Line line) {
        if (lines.isEmpty()) {
            throw new LineEmptyException();
        }
        if (lines.contains(line)) {
            lines.remove(line);
            return;
        }
        throw new LineNotExistException();
    }
}
