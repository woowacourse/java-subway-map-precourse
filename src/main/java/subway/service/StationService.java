package subway.service;

import subway.domain.station.StationRepository;

public class StationService {
    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }
}
