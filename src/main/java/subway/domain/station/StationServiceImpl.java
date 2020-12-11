package subway.domain.station;

import subway.domain.station.dto.StationSaveReqDto;

public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public void saveStation(StationSaveReqDto saveReqDto) {
        Station station = Station.of(saveReqDto.getName());
        stationRepository.addStation(station);
    }
}
