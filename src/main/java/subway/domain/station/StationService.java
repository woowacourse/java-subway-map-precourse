package subway.domain.station;

import subway.domain.station.dto.StationDeleteReqDto;
import subway.domain.station.dto.StationSaveReqDto;

public interface StationService {
    Station saveStation(StationSaveReqDto saveReqDto);

    Station findByName(String name);

    Stations getStations();

    boolean deleteStation(StationDeleteReqDto deleteReqDto);

    void checkExist(String stationName);

    void checkNotFound(String stationName);

    void removeAll();
}
