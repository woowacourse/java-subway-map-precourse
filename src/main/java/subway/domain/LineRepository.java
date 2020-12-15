package subway.domain;

import subway.exception.DuplicationException;
import subway.exception.LineDuplicationException;
import subway.exception.LineNotExistException;
import subway.exception.NotExistException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static boolean addLine(Line line) {
        if (checkLineDuplication(line)) {
            return false;
        }
        lines.add(line);
        return true;
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean contains(Line line) {
        return lines.stream().anyMatch(l -> Objects.equals(l, line));
    }

    public static boolean contains(String lineName) {
        return lines.stream().anyMatch(line -> Objects.equals(line.getName(), lineName));
    }

    public static Line findLineByName(String name) {
        return lines.stream().filter(line -> Objects.equals(line.getName(), name)).findAny().orElse(null);
    }

    private static boolean checkLineDuplication(Line line) {
        try {
            if (LineRepository.contains(line)) {
                throw new LineDuplicationException(line);
            }

            return false;
        } catch (DuplicationException e) {
            System.out.println(e.getMessage() + "\n");
            return true;
        }
    }
}
