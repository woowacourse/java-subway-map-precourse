package subway.service;

import subway.domain.station.Station;
import subway.exception.station.SameUpLineAndDownLineException;
import subway.exception.station.StationNotFoundException;
import subway.exception.SubwayApplicationException;
import subway.repository.station.StationRepository;
import subway.specification.StationAlreadyRegisteredSpecification;
import subway.specification.SameUpLineAndDownLineSpecification;
import subway.domain.line.Line;

public class LineGenerateService {
    private final StationRepository stationRepository;

    public LineGenerateService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Line generate(String name, Station upLine, Station downLine) {
        try {
            validateSameUpLineAndDownLine(upLine, downLine);
            validateIsRegisteredStation(upLine);
            validateIsRegisteredStation(downLine);
        } catch (SameUpLineAndDownLineException | StationNotFoundException e) {
            throw new SubwayApplicationException(e);
        }

        return Line.fromNameAndUpLineAndDownLine(name, upLine, downLine);
    }

    private void validateSameUpLineAndDownLine(Station upLine, Station DownLine) {
        SameUpLineAndDownLineSpecification sameUpLineAndDownLineSpecification =
                new SameUpLineAndDownLineSpecification();

        if (sameUpLineAndDownLineSpecification.isSatisfiedBy(upLine, DownLine)) {
            throw new SameUpLineAndDownLineException();
        }
    }

    private void validateIsRegisteredStation(Station station) {
        StationAlreadyRegisteredSpecification stationAlreadyRegisteredSpecification =
                new StationAlreadyRegisteredSpecification(stationRepository);

        if (!stationAlreadyRegisteredSpecification.isSatisfiedBy(station)) {
            throw new StationNotFoundException();
        }
    }
}
