package subway.specification;

import subway.domain.line.LineName;
import subway.repository.line.LineRepository;

import java.util.Objects;

public class LineExistSpecification {
    private final LineRepository lineRepository;

    public LineExistSpecification(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public boolean isSatisfiedBy(LineName name) {
        return lineRepository.lines().stream()
                .anyMatch(line -> Objects.equals(line.getName(), name));
    }

}
