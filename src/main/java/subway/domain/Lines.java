package subway.domain;

import subway.exception.SubwayException;

import static subway.util.TextConstant.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public void deleteLine(String name) {
        if (!lines.removeIf(line -> Objects.equals(line.getName(), name))) {
            throw new SubwayException(ERR_NO_SUCH_NAME_LINE_MSG);
        }
    }

    public void addLine(Line line) {
        if (!lines.contains(line)) {
            lines.add(line);
            return;
        }
        throw new SubwayException(ERR_ALREADY_ADD_LINE_NAME_MSG);
    }

    public int size() {
        return lines.size();
    }

    public Line findLine(String name) {
        return lines.stream()
                .filter(line -> Objects.equals(line.getName(), name))
                .findFirst()
                .orElseThrow(() -> new SubwayException(ERR_NO_SUCH_NAME_LINE_MSG));
    }

    public boolean containsStation(Station station) {
        return lines.stream()
                .anyMatch(line -> line.containsStation(station));
    }

    public List<String> lineNames() {
        return lines.stream()
                .map(Line::getName)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public boolean isPresentLine(String name) {
        return lines.stream()
                .anyMatch(line -> Objects.equals(line.getName(), name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lines)) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
