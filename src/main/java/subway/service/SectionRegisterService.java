package subway.service;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.exception.SubwayApplicationException;
import subway.exception.line.PositionRangeException;
import subway.exception.station.StationAlreadyExistException;
import subway.repository.line.LineRepository;
import subway.repository.station.StationRepository;
import subway.specification.StationExistOnSpecificLineSpecification;

public class SectionRegisterService {
    private final StationRepository stationRepository;
    private final LineRepository lineRepository;

    public SectionRegisterService(StationRepository stationRepository,
                                  LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    public void add(String lineName, String stationName, String position) {
        try {
            StationName convertedStationName = StationName.of(stationName);
            LineName convertedLineName = LineName.of(lineName);

            Station station = findStationFromRepository(convertedStationName);
            Line line = findLineFromRepository(convertedLineName);

            isRightPosition(line, toInteger(position));
            validateDuplicateStationOnLine(convertedLineName, station.getName());

            lineRepository.findLineByName(convertedLineName).add(toInteger(position), station);
        } catch (RuntimeException e) {
            throw new SubwayApplicationException(e);
        }
    }

    private int toInteger(String position) {
        return Integer.parseInt(position);
    }


    private void isRightPosition(Line line, int position) {
        if (!line.isRightPosition(position)) {
            throw new PositionRangeException();
        }
    }

    private Station findStationFromRepository(StationName stationName) {
        return stationRepository.getStationByName(stationName);
    }

    private Line findLineFromRepository(LineName lineName) {
        return lineRepository.findLineByName(lineName);
    }

    private void validateDuplicateStationOnLine(LineName lineName, StationName stationName) {
        StationExistOnSpecificLineSpecification stationExistOnSpecificLineSpecification =
                new StationExistOnSpecificLineSpecification(lineRepository);

        if (stationExistOnSpecificLineSpecification.isSatisfiedBy(lineName, stationName)) {
            throw new StationAlreadyExistException();
        }
    }
}
