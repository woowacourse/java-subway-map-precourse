package subway.service;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.station.StationName;
import subway.exception.SubwayApplicationException;
import subway.exception.line.LineNotFoundException;
import subway.exception.line.SectionSizeLowException;
import subway.exception.station.StationNotFoundException;
import subway.repository.line.LineRepository;

public class LineDeleteStationService {
    private final LineRepository lineRepository;

    public LineDeleteStationService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public void delete(LineName lineName, StationName stationName) {
        try {
            deleteStation(lineName, stationName);
        } catch (LineNotFoundException | StationNotFoundException | SectionSizeLowException e) {
            throw new SubwayApplicationException(e);
        }
    }

    private void deleteStation(LineName lineName, StationName stationName) {
        Line line = findLineByName(lineName);

        if (!line.deleteStationByName(stationName)) {
            throw new StationNotFoundException();
        }
    }

    private Line findLineByName(LineName lineName) {
        return lineRepository.findLineByName(lineName);
    }
}
