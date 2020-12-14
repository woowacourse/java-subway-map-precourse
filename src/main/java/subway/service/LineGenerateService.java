package subway.service;

import subway.domain.line.LineName;
import subway.domain.station.Station;
import subway.exception.line.LineNameFormatException;
import subway.exception.line.LineNameLengthException;
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
        LineName lineName;
        try {
            validateSameUpLineAndDownLine(upLine, downLine);
            validateIsRegisteredStation(upLine);
            validateIsRegisteredStation(downLine);

            lineName = LineName.of(name);
        } catch (SameUpLineAndDownLineException | StationNotFoundException |
                LineNameFormatException | LineNameLengthException e) {
            throw new SubwayApplicationException(e);
        }

        return Line.fromNameAndUpLineAndDownLine(lineName, upLine, downLine);
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
