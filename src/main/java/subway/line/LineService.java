package subway.line;

import subway.line.validation.*;
import subway.station.Station;

import java.util.List;

public class LineService {
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
        CheckRegisteredLine.validation(lineName);
        return LineRepository.findByName(lineName);
    }

    public static List<Line> allLine() {
        return LineRepository.lines();
    }
}
