package subway.controller;

import java.util.List;
import subway.service.SubwayService;

public class StationController {
    private final SubwayService subwayService;

    public StationController(SubwayService subwayService) {
        this.subwayService = subwayService;
    }

    public void addStations(List<String> stations) {
        subwayService.addAll(stations);
    }
}
