package subway.specification;

import subway.domain.station.StationName;
import subway.repository.line.LineRepository;

public class StationExistOnLineSpecification {
    private final LineRepository lineRepository;

    public StationExistOnLineSpecification(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public boolean isSatisfiedBy(StationName name) {
        return lineRepository.lines().stream()
                .anyMatch(line -> line.contains(name));
    }
}
