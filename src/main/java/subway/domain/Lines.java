package subway.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lines {
    private static final String ERR_NO_SUCH_NAME_LINE_MSG = "[ERROR] 해당 노선이 없습니다.";

    private List<Line> lines = new ArrayList<>();

    public boolean deleteLine(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public Line findLine(String name) {
        return lines.stream()
                .filter(line -> Objects.equals(line.getName(), name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(ERR_NO_SUCH_NAME_LINE_MSG));
    }

    public List<String> lineNames() {
        return lines.stream()
                .map(Line::getName)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
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
