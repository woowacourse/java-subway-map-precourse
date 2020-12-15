package subway.service;

import subway.domain.line.LineName;
import subway.exception.SubwayApplicationException;
import subway.exception.line.LineNotFoundException;
import subway.repository.line.LineRepository;

public class LineDeleteService {
    private final LineRepository lineRepository;

    public LineDeleteService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public void delete(LineName name) {
        try {
            deleteLine(name);
        } catch (LineNotFoundException e) {
            throw new SubwayApplicationException(e);
        }
    }

    private void deleteLine(LineName name) {
        boolean success = lineRepository.deleteLineByName(name);
        if (!success) {
            throw new LineNotFoundException();
        }
    }
}
