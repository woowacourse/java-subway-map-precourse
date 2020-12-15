package subway.line;

import subway.line.validation.*;
import subway.station.Station;

import java.util.List;

public class LineService {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NOT_EXIST = ERROR_PREFIX + "등록되지 않은 노선입니다.";

    public static void addLine(Line line) {
        LineRepository.addLine(line);
    }

    public static boolean addLine(Line line, Station startStation, Station endStation) {
        line.addStation(startStation);
        line.addStation(endStation);
        LineRepository.addLine(line);
        return true;
    }

    public static boolean deleteLine(String lineName) {
        CheckRegisteredLine.validation(lineName);
        return LineRepository.deleteLineByName(lineName);
    }

    public static Line findLine(String lineName) {
        Line line = LineRepository.findByName(lineName);
        if (line == null) {
            throw new IllegalArgumentException(NOT_EXIST);
        }
        return line;
    }

    public static List<Line> allLine() {
        return LineRepository.lines();
    }
}
