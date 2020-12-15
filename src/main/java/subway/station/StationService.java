package subway.station;

import subway.line.validation.CheckStationRegisteredLine;
import subway.station.validation.CheckRegisteredStation;

import java.util.List;

public class StationService {
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
        CheckRegisteredStation.validation(stationName);
        return StationRepository.findByName(stationName);
    }

    public static List<Station> AllStation() {
        return StationRepository.stations();
    }
}
