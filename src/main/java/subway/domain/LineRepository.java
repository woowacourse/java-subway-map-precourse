package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import subway.controller.ManagementController;
import subway.exception.function.AlreadyExistsException;
import subway.exception.function.NotFoundElementException;

public final class LineRepository {

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

    public LineRepository addLine(final String lineName, final String... stations) {
        return addLine(new Line(lineName, stations));
    }

    public LineRepository addLine(final Line line) {
        if (lines.contains(line)) {
            throw new AlreadyExistsException(line.getName(), ManagementController.LINE);
        }

        lines.add(line);

        return this;
    }

    public LineRepository removeLine(final String lineName) {
        boolean removed = lines.removeIf(line -> Objects.equals(line.getName(), lineName));

        if (!removed) {
            throw new NotFoundElementException(lineName);
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

    public List<String> getStationNamesByLineName(final String lineName) {
        Line line = getLineByLineName(lineName);

        return line.getStations().stationNames();
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
                .orElseThrow(() -> new NotFoundElementException(lineName));
    }
}
