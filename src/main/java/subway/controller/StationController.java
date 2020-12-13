package subway.controller;

import java.util.List;
import subway.domain.Station;
import subway.service.StationService;
import subway.view.OutputView;

public class StationController {
    public static boolean registerStation(String stationName) {
        try {
            StationService.register(stationName);
            OutputView.print(OutputView.SUCCESS_TO_REGISTER_STATION_MESSAGE);
            return false;
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return true;
        }
    }

    public static List<Station> searchStation() {
        return StationService.search();
    }

    public static boolean deleteStation(String stationName) {
        try {
            StationService.delete(stationName);
            OutputView.print(OutputView.SUCCESS_TO_DELETE_STATION_MESSAGE);
            return false;
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return true;
        }
    }
}
