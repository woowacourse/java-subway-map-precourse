package subway.service;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;

public class LineService implements SubwayService {
    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    @Override
    public void addAll(List<String> lines) {
        for (String line : lines) {
            lineRepository.addLine(new Line(line));
        }
    }

    @Override
    public void add(String line) {
        lineRepository.addLine(new Line(line));
    }

    @Override
    public void delete(String line) {
        lineRepository.deleteLineByName(line);
    }
}
