package subway.repository;

import subway.domain.Line;
import subway.domain.Station;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static subway.view.OutputView.*;

public class LineRepository {
    private static final String LINE_DUPLICATE_WARN = "노선 이름은 중복이 되어서는 안됩니다.\n";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static boolean addLine(Line line) {
        if (lines.contains(line)) {
            warnMessage(LINE_DUPLICATE_WARN);
            return false;
        }
        lines.add(line);
        return true;
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isLineExist(String lineName) {
        return lines.stream()
                .anyMatch(line -> line.getName().equals(lineName));
    }

    public static boolean isStationExistInLine(Station station) {
        return lines.stream()
                .anyMatch(line -> line.getStationList()
                        .stream()
                        .anyMatch(Predicate.isEqual(station)));
    }
}