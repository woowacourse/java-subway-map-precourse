package subway.controller;

import subway.domain.station.Station;
import subway.service.StationService;

public class SubwayMapController {
    private final StationService stationService;

    public SubwayMapController(StationService stationService) {
        this.stationService = stationService;
    }

    public void registerStation(Station station) {
        stationService.addStation(station);
    }

    public void unregisterStation(String stationName) {
        // TODO : 노선에 등록되어 있는지 체크
        // lineService.isExistent(stationName)
        stationService.deleteStation(stationName);
    }
}
