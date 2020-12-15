package subway.line;

import subway.line.validation.*;
import subway.station.Station;

import java.util.List;

public class LineService {
    public static void addLine(Line line) {
        LineRepository.addLine(line);
    }

    public static void addLineWithStartEndStation(Line line, Station startStation, Station endStation) {
        line.addStation(startStation);
        line.addStation(endStation);
        LineRepository.addLine(line);
    }

    public static void deleteLine(String lineName) {
        LineRepository.deleteLineByName(lineName);
    }

    public static Line findLine(String lineName) {
        CheckRegisteredLine.validation(lineName);
        return LineRepository.findByName(lineName);
    }

    public static List<Line> allLine() {
        return LineRepository.lines();
    }
}
