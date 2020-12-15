package subway.specification;

import subway.domain.station.Station;
import subway.exception.station.StationNotFoundException;
import subway.repository.station.StationRepository;

public class StationAlreadyRegisteredSpecification {
    StationRepository stationRepository;

    public StationAlreadyRegisteredSpecification(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public boolean isSatisfiedBy(Station station) {
        try {
            stationRepository.getStationByName(station.getName());
        } catch(StationNotFoundException e) {
            return false;
        }

        return true;
    }
}
