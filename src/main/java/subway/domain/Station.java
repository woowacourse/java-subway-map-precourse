package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;
    private List<Line> lines;

    public Station(String name) {
        this.name = name;
        this.lines = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBelongingLine(Line line) {
        lines.add(line);
    }

    public void deleteBelongingLine(Line line) {
        lines.remove(line);
    }

    public List<Line> getBelongingLines() {
        return lines;
    }
}
