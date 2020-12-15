package subway.station;

import subway.line.validation.CheckStationRegisteredLine;
import subway.station.validation.CheckRegisteredStation;

import java.util.List;

public class StationService {
    public static void addStation(Station station) {
        StationRepository.addStation(station);
    }

    public static void deleteStation(String stationName) {
        StationRepository.deleteStation(stationName);
    }

    public static Station findStation(String stationName) {
        CheckRegisteredStation.validation(stationName);
        return StationRepository.findByName(stationName);
    }

    public static List<Station> AllStation() {
        return StationRepository.stations();
    }
}
