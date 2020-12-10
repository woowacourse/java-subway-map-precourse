package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    public static final String DUPLICATE_NAME_ERROR = "%s은 이미 존재하는 노선 이름입니다!";

    public static final String DOES_NOT_EXIST_ERROR = "%s은 존재하지 않습니다.";

    private final List<Line> lines;

    public LineRepository() {
        this.lines = new LinkedList<>();
    }

    public LineRepository(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public LineRepository addLine(Line line) {
        if (lines.contains(line)) {
            throw new IllegalArgumentException(String.format(DUPLICATE_NAME_ERROR, line.getName()));
        }

        lines.add(line);

        return this;
    }

    public LineRepository insertStation(String lineName, int index, String stationName) {
        Line line = getLineByLineName(lineName);
        Line insertedLine = line.insertStation(index, stationName);

        int lineIndex = lines.indexOf(line);

        lines.set(lineIndex, insertedLine);

        return new LineRepository(lines);
    }

    public LineRepository deleteLineByName(String name) {
        boolean removed = lines.removeIf(line -> Objects.equals(line.getName(), name));

        if (!removed) {
            throw new IllegalArgumentException(String.format(DOES_NOT_EXIST_ERROR, name));
        }

        return new LineRepository(lines);
    }

    public boolean contains(String stationName) {
        return lines.stream().anyMatch(line -> line.contains(stationName));
    }

    public LineRepository deleteStation(String lineName, String stationName) {
        Line line = getLineByLineName(lineName);

        int lineIndex = lines.indexOf(line);

        line = line.remove(stationName);

        lines.set(lineIndex, line);

        return new LineRepository(lines);
    }

    private Line getLineByLineName(String lineName) {
        return lines.stream()
                .filter(line -> line.getName().equals(lineName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format(DOES_NOT_EXIST_ERROR, lineName)));
    }
}
