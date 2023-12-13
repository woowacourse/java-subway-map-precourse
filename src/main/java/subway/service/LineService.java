package subway.service;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.global.exception.CustomException;
import subway.global.exception.ErrorMessage;

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
        if (lineRepository.findByName(line).isPresent()) {
            throw CustomException.from(ErrorMessage.LINE_DUPLICATED_ERROR);
        }
        lineRepository.addLine(new Line(line));
    }

    @Override
    public void delete(String line) {
        if (lineRepository.findByName(line).isEmpty()) {
            throw CustomException.from(ErrorMessage.LINE_NOT_FOUND_ERROR);
        }
        lineRepository.deleteLineByName(line);
    }

    @Override
    public List<String> getAll() {
        return null;
    }
}
