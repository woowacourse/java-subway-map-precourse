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
}
