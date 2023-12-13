package subway.controller;

import java.util.List;
import subway.domain.constants.StationCommand;
import subway.service.SubwayService;
import subway.view.StationView;

public class StationController {
    private final SubwayService subwayService;
    private final StationView stationView;

    public StationController(SubwayService subwayService, StationView stationView) {
        this.subwayService = subwayService;
        this.stationView = stationView;
    }

    public void addStations(List<String> stations) {
        subwayService.addAll(stations);
    }

    public void run() {
        stationView.printFunctions();
        StationCommand function = stationView.enterFunction();
        if (function.equals(StationCommand.ADD)) {
            addStation();
        }
        if (function.equals(StationCommand.DELETE)) {
            deleteStation();
        }
        if (function.equals(StationCommand.GET)) {
            getStation();
        }
    }

    private void addStation() {
        String name = stationView.enterStationName();
        subwayService.add(name);
        stationView.printAddResult();
    }
}
