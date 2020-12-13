package subway.domain.station;

import subway.domain.station.dto.StationDeleteReqDto;
import subway.domain.station.dto.StationSaveReqDto;

public interface StationService {
    Station saveStation(StationSaveReqDto saveReqDto);

    Station findByName(String stationName);

    Stations getStations();

    boolean deleteStation(StationDeleteReqDto deleteReqDto);

    void removeAll();

    boolean containLine(String stationName);

    void checkAlreadyExist(String stationName);

    void checkNotFound(String stationName);
}
