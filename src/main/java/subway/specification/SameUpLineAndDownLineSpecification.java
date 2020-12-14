package subway.specification;

import subway.domain.station.Station;

import java.util.Objects;

public class SameUpLineAndDownLineSpecification {
    public boolean isSatisfiedBy(Station upLine, Station downLine) {
        return Objects.equals(upLine, downLine);
    }
}
