package subway.repository;

import subway.domain.Line;
import subway.exception.SubwayException;
import subway.utils.ValidateUtils;
import subway.view.OutputView;
import subway.view.TextCollection;

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
        ValidateUtils.isTwoOrMoreLetters(line.getName());
        ValidateUtils.isDuplicatedLine(line.getName());
        lines.add(line);
    }

    public static void deleteLineByName(String name) {
        if (!lines.removeIf(line -> Objects.equals(line.getName(), name))) {
            throw new SubwayException(TextCollection.NOT_EXIST_LINE_MESSAGE);
        }
    }

    public static void printAllLine() {
        lines.forEach(line -> OutputView.printStationOrLine(line.getName()));
    }

    public static Line searchLine(String name) {
        return lines.stream()
                .filter(line -> Objects.equals(line.getName(), name))
                .findFirst()
                .orElseThrow(() -> new SubwayException(TextCollection.NOT_EXIST_LINE_MESSAGE));
    }
}
