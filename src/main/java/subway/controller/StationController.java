package subway.controller;

import java.util.List;
import subway.domain.Station;
import subway.service.StationService;
import subway.view.OutputView;

public class StationController {
    private OutputView monitor;

    public StationController(OutputView monitor) {
        this.monitor = monitor;
    }

    public boolean registerStation(String stationName) {
        try {
            StationService.register(stationName);
            monitor.print(OutputView.SUCCESS_TO_REGISTER_STATION_MESSAGE);
            return false;
        } catch (Exception e) {
            monitor.print(e.getMessage());
            return true;
        }
    }

    public List<Station> searchStation() {
        return StationService.search();
    }

    public boolean deleteStation(String stationName) {
        try {
            StationService.delete(stationName);
            monitor.print(OutputView.SUCCESS_TO_DELETE_STATION_MESSAGE);
            return false;
        } catch (Exception e) {
            monitor.print(e.getMessage());
            return true;
        }
    }
}
