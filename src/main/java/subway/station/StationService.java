package subway.station;

import subway.line.validation.CheckStationRegisteredLine;
import subway.station.validation.CheckRegisteredStation;
import subway.view.station.StationManagementView;

import java.util.List;

public class StationService {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NOT_EXIST = ERROR_PREFIX + "등록되지 않은 역입니다.";

    public static boolean addStation(String stationName) {
        boolean isAdd = false;
        try {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
            isAdd = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isAdd;
    }

    public static boolean deleteStation(String stationName) {
        boolean isDelete = false;
        try {
            CheckRegisteredStation.validation(stationName);
            CheckStationRegisteredLine.validation(stationName);
            isDelete = StationRepository.deleteStation(stationName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isDelete;
    }

    public static Station findStation(String stationName) {
        Station station = StationRepository.findByName(stationName);
        if (station == null) {
            throw new IllegalArgumentException(NOT_EXIST);
        }
        return station;
    }

    public static boolean printAllStation() {
        List<Station> stations = StationRepository.stations();
        StationManagementView.printAllStation(stations);
        return true;
    }
}
