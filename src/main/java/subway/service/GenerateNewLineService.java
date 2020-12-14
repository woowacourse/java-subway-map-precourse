package subway.service;

import subway.domain.station.Station;
import subway.exception.SameUpLineAndDownLineException;
import subway.exception.StationNotFoundException;
import subway.exception.SubwayApplicationException;
import subway.repository.line.LineRepository;
import subway.repository.line.LineRepositoryImpl;
import subway.repository.station.StationRepository;
import subway.repository.station.StationRepositoryImpl;
import subway.specification.AlreadyRegisteredStationSpecification;
import subway.specification.SameUpLineAndDownLineSpecification;
import subway.domain.line.Line;

public class GenerateNewLineService {
    private final StationRepository stationRepository;

    public GenerateNewLineService(StationRepository stationRepository) {
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
        AlreadyRegisteredStationSpecification alreadyRegisteredStationSpecification =
                new AlreadyRegisteredStationSpecification(stationRepository);

        if (!alreadyRegisteredStationSpecification.isSatisfiedBy(station)) {
            throw new StationNotFoundException();
        }
    }
}
