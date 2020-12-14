package subway.service;

import subway.domain.line.Line;
import subway.repository.line.LineRepository;

import java.util.List;

public class LineListService {
    private final LineRepository lineRepository;

    public LineListService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public List<Line> get() {
        return lineRepository.lines();
    }
}
