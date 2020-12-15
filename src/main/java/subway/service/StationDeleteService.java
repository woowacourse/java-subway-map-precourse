package subway.service;

import subway.domain.station.StationName;
import subway.exception.station.StationRegisteredOnLineException;
import subway.exception.SubwayApplicationException;
import subway.exception.station.StationNotFoundException;
import subway.repository.line.LineRepository;
import subway.repository.station.StationRepository;
import subway.specification.StationExistOnLineSpecification;

public class StationDeleteService {
    private final StationRepository stationRepository;
    private final LineRepository lineRepository;

    public StationDeleteService(StationRepository stationRepository,
                                LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    public void delete(StationName name) {
        try {
            validateLineContainsStation(name);
            deleteStation(name);
        } catch (StationNotFoundException | StationRegisteredOnLineException e) {
            throw new SubwayApplicationException(e);
        }
    }

    private void deleteStation(StationName name) {
        boolean success = stationRepository.deleteStation(name);
        if (!success) {
            throw new StationNotFoundException();
        }
    }

    private void validateLineContainsStation(StationName name) {
        StationExistOnLineSpecification stationExistOnLineSpecification =
                new StationExistOnLineSpecification(lineRepository);

        if (stationExistOnLineSpecification.isSatisfiedBy(name)) {
            throw new StationRegisteredOnLineException();
        }
    }
}
