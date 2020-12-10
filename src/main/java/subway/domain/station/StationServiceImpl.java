package subway.domain.station;

import java.util.List;

public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public void saveStation(String stationName) {
        Station station = Station.of(stationName);
        stationRepository.addStation(station);
    }
}
