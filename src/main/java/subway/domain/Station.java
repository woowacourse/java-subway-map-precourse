package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private final String name;
    private final List<Line> lines = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addLine(Line line) {
        if (LineRepository.lines().contains(line)) {
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
