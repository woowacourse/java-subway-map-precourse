package subway.controller;

import java.util.List;
import subway.domain.Station;
import subway.service.StationService;
import subway.view.LogMessage;
import subway.view.OutputView;

public class StationController {
    public static void registerStation(String stationName) {
        try {
            StationService.register(stationName);
            LogMessage.printSuccessToRegisterStation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void searchStation() {
        List<Station> stations = StationService.search();
        OutputView.printStationList();
        LogMessage.printStationList(stations);
    }

    public static void deleteStation(String stationName) {
        try {
            StationService.delete(stationName);
            LogMessage.printSuccessToDeleteStation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
