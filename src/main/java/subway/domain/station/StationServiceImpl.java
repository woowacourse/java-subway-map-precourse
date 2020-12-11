package subway.domain.station;

import subway.domain.station.dto.StationSaveReqDto;
import subway.exception.ErrorCode;
import subway.exception.StationException;

public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public Station saveStation(StationSaveReqDto saveReqDto) {
        Station station = Station.of(saveReqDto.getName());
        Station stationFindByName = stationRepository.findByName(station.getName());
        if (stationFindByName != null){
            throw new StationException(ErrorCode.STATION_ALEADY_EXIST);
        }
        stationRepository.addStation(station);
        return station;
    }
}
