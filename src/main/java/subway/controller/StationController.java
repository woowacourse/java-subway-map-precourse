package subway.controller;

import java.util.List;
import subway.domain.Station;
import subway.service.StationService;
import subway.view.OutputView;

public class StationController {
    private static final Boolean BACK_TO_UPPER_SCREEN = false;
    private static final Boolean RETRY = true;

    public static boolean registerStation(String stationName) {
        try {
            StationService.register(stationName);
            OutputView.print(OutputView.SUCCESS_TO_REGISTER_STATION_MESSAGE);
            return BACK_TO_UPPER_SCREEN;
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return RETRY;
        }
    }

    public static List<Station> searchStation() {
        return StationService.searchAll();
    }

    public static boolean deleteStation(String stationName) {
        try {
            StationService.delete(stationName);
            OutputView.print(OutputView.SUCCESS_TO_DELETE_STATION_MESSAGE);
            return BACK_TO_UPPER_SCREEN;
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return RETRY;
        }
    }
}
