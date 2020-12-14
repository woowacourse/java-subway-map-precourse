package subway.domain;

import subway.domain.exception.NonExistingLineException;
import subway.domain.validator.LineValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        LineValidator.checkNotExistingLine(lines.contains(line));
        lines.add(line);
    }

    public static void remove(Line line) {
        line.removeAllStations();
        lines.remove(line);
    }

    public static List<String> getLineNames() {
        return lines.stream()
                .map(Line::toString)
                .collect(Collectors.toList());
    }

    public static Line getByName(Name name) {
        return lines.stream()
                .filter(line -> line.isName(name))
                .findFirst()
                .orElseThrow(() -> new NonExistingLineException());
    }
}
