package subway.station;

import subway.line.validation.CheckStationRegisteredLine;
import subway.station.validation.CheckRegisteredStation;

import java.util.List;

public class StationService {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NOT_EXIST = ERROR_PREFIX + "등록되지 않은 역입니다.";

    public static boolean addStation(String stationName) {
        Station station = new Station(stationName);
        StationRepository.addStation(station);
        return true;
    }

    public static boolean deleteStation(String stationName) {
        CheckRegisteredStation.validation(stationName);
        CheckStationRegisteredLine.validation(stationName);
        return StationRepository.deleteStation(stationName);
    }

    public static Station findStation(String stationName) {
        Station station = StationRepository.findByName(stationName);
        if (station == null) {
            throw new IllegalArgumentException(NOT_EXIST);
        }
        return station;
    }

    public static List<Station> AllStation() {
        return StationRepository.stations();
    }
}
