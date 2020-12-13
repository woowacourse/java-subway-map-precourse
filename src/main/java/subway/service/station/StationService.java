package subway.service.station;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.dto.station.StationRequestDto;

public class StationService {

    public static boolean save(StationRequestDto stationRequestDto) {
        Station newStation = Station.getStation(stationRequestDto.getName());
        StationRepository.save(newStation);
        System.out.println(StationRepository.save(newStation));
        return true;
    }
}
