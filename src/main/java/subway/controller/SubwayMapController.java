package subway.controller;

import subway.service.StationService;

public class SubwayMapController {

    private final StationService stationService;

    public SubwayMapController(StationService stationService) {
        this.stationService = stationService;
    }

    public void addStationByName(String stationName) {
        stationService.addStationByName(stationName);
    }
}
