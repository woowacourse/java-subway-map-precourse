package subway.service;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.exception.SubwayApplicationException;
import subway.exception.line.LineAlreadyExistException;
import subway.exception.station.StationAlreadyExistException;
import subway.repository.line.LineRepository;;
import subway.specification.LineExistSpecification;

public class LineRegisterService {
    private final LineRepository lineRepository;

    public LineRegisterService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public void register(Line line) {
        try {
            validateAlreadyExist(line.getName());
            lineRepository.addLine(line);
        } catch (StationAlreadyExistException e) {
            throw new SubwayApplicationException(e);
        }
    }

    private void validateAlreadyExist(LineName name) {
        LineExistSpecification lineExistSpecification =
                new LineExistSpecification(lineRepository);

        if (lineExistSpecification.isSatisfiedBy(name)) {
            throw new LineAlreadyExistException();
        }
    }
}
