package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void removeOrderedLine(Line line) {
        for (Station station : StationRepository.fixedStations()) {
            if (station.getName().equals(getName()) && station.getLines().contains(line)) {
                //삭제할 수 없는 노선입니다
                return;
            }
        }
        if (LineRepository.lines().contains(line)) {
            lines.removeIf(line1 -> Objects.equals(line1.getName(), line.getName()));
        }
    }
}
