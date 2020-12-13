package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    public void registerStation(String stationName) {
        Station newStation = new Station(stationName);
        StationRepository.addStation(newStation);
    }

    public void deleteStation(String stationName) {
        StationRepository.deleteStation(stationName);
    }
}
