package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lines {
    private List<Line> lines = new ArrayList<>();

    public boolean deleteLine(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public void addLine(Line line) {
        lines.add(line);
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
