package subway.service;

import subway.domain.station.Station;
import subway.repository.station.StationRepository;

import java.util.List;

public class StationListService {
    private final StationRepository stationRepository;

    public StationListService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public List<Station> get() {
        return stationRepository.stations();
    }
}
