package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    private static final String STATION_REGISTERED_TO_LINE = "\n[ERROR] 노선에 등록되어 있는 역 입니다.";

    public void registerStation(String stationName) {
        Station newStation = new Station(stationName);
        StationRepository.addStation(newStation);
    }

    public void deleteStation(String stationName) throws IllegalArgumentException {
        validateIfBelongToLine(StationRepository.findStationByName(stationName));
        StationRepository.deleteStation(stationName);
    }

    private void validateIfBelongToLine(Station station) throws IllegalArgumentException {
        if (station.isRegisteredToLine()) {
            throw new IllegalArgumentException(STATION_REGISTERED_TO_LINE);
        }
    }
}
