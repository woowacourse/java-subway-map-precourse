package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LineRepository {

    public static final String DUPLICATE_NAME_ERROR = "%s은 이미 존재하는 노선 이름입니다!";

    public static final String DOES_NOT_EXIST_ERROR = "%s은 존재하지 않습니다.";

    private final List<Line> lines;

    public LineRepository() {
        this.lines = new LinkedList<>();
    }

    public LineRepository(final List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public LineRepository addLine(final Line line) {
        if (lines.contains(line)) {
            throw new IllegalArgumentException(String.format(DUPLICATE_NAME_ERROR, line.getName()));
        }

        lines.add(line);

        return this;
    }

    public LineRepository removeLine(final String lineName) {
        boolean removed = lines.removeIf(line -> Objects.equals(line.getName(), lineName));

        if (!removed) {
            throw new IllegalArgumentException(String.format(DOES_NOT_EXIST_ERROR, lineName));
        }

        return new LineRepository(lines);
    }

    public LineRepository addRange(final String lineName, final int index,
                                   final String stationName) {
        return perform(lineName, line -> line.insert(index, stationName));
    }

    public LineRepository removeRange(final String lineName, final String stationName) {
        return perform(lineName, line -> line.remove(stationName));
    }

    public boolean contains(final String stationName) {
        return lines.stream().anyMatch(line -> line.contains(stationName));
    }

    public List<String> lineNames() {
        return lines.stream().map(Line::getName).collect(Collectors.toList());
    }

    private LineRepository perform(final String lineName, final Function<Line, Line> lineFunction) {
        Line line = getLineByLineName(lineName);

        int lineIndex = lines.indexOf(line);

        line = lineFunction.apply(line);

        lines.set(lineIndex, line);

        return new LineRepository(lines);
    }

    private Line getLineByLineName(final String lineName) {
        return lines.stream()
                .filter(line -> line.equalsName(lineName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format(DOES_NOT_EXIST_ERROR, lineName)));
    }
}
