package subway.service;

import subway.domain.Line;
import subway.repository.LineRepository;

import java.util.List;

public class LineService {
    public static List<Line> lines() {
        return LineRepository.lines();
    }

    public static void addLine(String lineName) {
        Line line = new Line(lineName);
        LineRepository.addLine(line);
    }

    public static void deleteLineByName(String lineName) {
        LineRepository.deleteLineByName(lineName);
    }
}
