package subway.line;

import subway.station.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final String ALREADY_EXISTS_LINE_NAME_ERROR_MESSAGE = "이미 등록된 노선 이름입니다.";
    private static final String NOT_EXISTS_LINE_ERROR_MESSAGE = "존재하지 않는 노선입니다.";

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
                throw new IllegalArgumentException(ALREADY_EXISTS_LINE_NAME_ERROR_MESSAGE);
            }
        }
    }

    public void checkLineExist(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return;
            }
        }
        throw new IllegalArgumentException(NOT_EXISTS_LINE_ERROR_MESSAGE);
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
        throw new IllegalArgumentException(NOT_EXISTS_LINE_ERROR_MESSAGE);
    }
}
