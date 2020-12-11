package subway.domain.station;

import subway.domain.station.dto.StationSaveReqDto;

public interface StationService {
    void saveStation(StationSaveReqDto saveReqDto);
}
