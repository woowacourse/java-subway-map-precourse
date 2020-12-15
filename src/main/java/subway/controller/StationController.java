package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputViewOfError;
import subway.view.OutputViewOfInfo;

public class StationController {
    private static final String STATION_LIST_MESSAGE = "## 역 목록";

    private static StationController stationController;

    public static StationController getInstance() {
        if (stationController==null) {
            stationController = new StationController();
        }
        return stationController;
    }


    public Boolean registerStation() {
        String name = InputView.registerStationName();
        Station station = new Station(name);
        boolean result = StationRepository.addStation(station);
        if (result) {
            OutputViewOfInfo.registerStationComplete();
        }
        return result;
    }

    public Boolean deleteStation() {
        String name = InputView.deleteStationName();
        boolean result = StationRepository.deleteStation(name);
        if (result) {
            OutputViewOfInfo.deleteStationComplete();
        }
        if (!result) {
            OutputViewOfError.cannotDeleteError();
        }
        return result;
    }

    public Boolean inquiryStation() {
        System.out.println(STATION_LIST_MESSAGE);
        StationRepository.printStationList();
        System.out.println();
        return true;
    }

    public Boolean back() {
        return true;
    }
}
