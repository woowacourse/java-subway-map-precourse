package subway.controller;

import subway.service.StationService;

import java.util.List;

public class SubwayMapController {

    private final StationService stationService;

    public SubwayMapController(StationService stationService) {
        this.stationService = stationService;
    }

    public void addStationByName(String stationName) {
        stationService.addStationByName(stationName);
    }

    public void deleteStationByName(String stationName) {
        stationService.deleteStationByName(stationName);
    }

    public List<String> getStationNames() {
        return stationService.getStationNames();
    }
}
