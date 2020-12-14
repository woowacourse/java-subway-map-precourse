package subway.service.station;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.dto.station.StationRequestDto;

public class StationService {

    public static final String STATION_DELETE_CONDITION_ERROR_MESSAGE = "[ERROR] 노선에 등록되어있는 역은 삭제가 불가능합니다.";

    public static boolean save(StationRequestDto stationRequestDto) {
        Station newStation = Station.getStation(stationRequestDto.getName());
        StationRepository.save(newStation);
        System.out.println(StationRepository.save(newStation));
        return true;
    }

    public static boolean delete(String stationName) {
        Station station = StationRepository.findStationName(stationName);
        if (LineList.contains(stationName)) {  // 노선에 역이 포함되어있다면
            throw new IllegalArgumentException(STATION_DELETE_CONDITION_ERROR_MESSAGE);
        }
        StationRepository.deleteStation(station);
    }
}
