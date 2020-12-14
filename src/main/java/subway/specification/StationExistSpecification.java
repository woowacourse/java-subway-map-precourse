package subway.specification;

import subway.domain.station.StationName;
import subway.repository.station.StationRepository;

import java.util.Objects;

public class StationExistSpecification {
    private final StationRepository stationRepository;

    public StationExistSpecification(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public boolean isSatisfiedBy(StationName name) {
        return stationRepository.stations().stream()
                .anyMatch(station -> Objects.equals(station.getName(), name));
    }
}
