package subway.domain.line.service;

import subway.domain.line.model.Line;
import subway.domain.line.model.LineRepository;

import java.util.List;

public class LineService {
    public static List<Line> findAll() {
        return LineRepository.lines();
    }

    public static void save(Line line) {
        LineRepository.addLine(line);
    }
}
