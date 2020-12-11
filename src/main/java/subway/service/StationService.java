package subway.service;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class StationService {
    public void addStation(Station station) {
        StationRepository.addStation(station);
    }
}
