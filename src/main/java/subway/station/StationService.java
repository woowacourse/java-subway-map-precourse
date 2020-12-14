package subway.station;

import subway.line.validation.CheckStationRegisteredLine;
import subway.station.validation.CheckRegisteredStation;
import subway.station.view.StationOutputView;

public class StationService {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NOT_EXIST = ERROR_PREFIX + "등록되지 않은 역입니다.";

    public static boolean addStation(String stationName) {
        try {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
            StationOutputView.addStationComplete();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean deleteStation(String stationName) {
        try {
            CheckRegisteredStation.validation(stationName);
            CheckStationRegisteredLine.validation(stationName);
            StationRepository.deleteStation(stationName);
            StationOutputView.deleteStationComplete();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static Station findStation(String stationName) {
        Station station = StationRepository.findByName(stationName);
        if (station == null) {
            throw new IllegalArgumentException(NOT_EXIST);
        }
        return station;
    }
}
