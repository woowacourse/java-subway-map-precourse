package subway.specification;

import subway.domain.line.LineName;
import subway.domain.station.StationName;
import subway.repository.line.LineRepository;

public class StationExistOnSpecificLineSpecification {
    private final LineRepository lineRepository;

    public StationExistOnSpecificLineSpecification(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public boolean isSatisfiedBy(LineName lineName, StationName stationName) {
        return lineRepository.findLineByName(lineName).contains(stationName);
    }
}
