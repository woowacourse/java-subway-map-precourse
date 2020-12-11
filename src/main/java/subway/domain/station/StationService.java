package subway.domain.station;

import subway.domain.station.dto.StationDeleteReqDto;
import subway.domain.station.dto.StationSaveReqDto;

public interface StationService {
    Station saveStation(StationSaveReqDto saveReqDto);

    Stations getStations();

    boolean deleteStation(StationDeleteReqDto deleteReqDto);
}
