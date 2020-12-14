package subway.line;

import subway.errors.DuplicateException;
import subway.errors.NotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private final List<Line> lines = new ArrayList<>();

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
                throw new DuplicateException("노선");
            }
        }
    }

    public void checkLineExist(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return;
            }
        }
        throw new NotFoundException();
    }

    public List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }

    public Line findByName(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return line;
            }
        }
        throw new NotFoundException();
    }
}
