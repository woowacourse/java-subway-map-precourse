package subway.line;

import subway.station.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private final List<Line> lines = new ArrayList<>();

    public List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public boolean isStationOnLine(String stationName) {
        for (Line line : lines) {
            if (line.isStationInLine(stationName)) {
                return true;
            }
        }
        return false;
    }

    public void checkDuplicateLine(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                throw new IllegalArgumentException("이미 등록된 노선 이름입니다.");
            }
        }
    }

    public void checkLineExist(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return;
            }
        }
        throw new IllegalArgumentException("존재 하지 않는 노선입니다.");
    }
}
