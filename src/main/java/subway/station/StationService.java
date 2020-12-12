package subway.station;

import subway.station.validation.CheckRegisteredStation;
import subway.station.view.StationOutputView;

public class StationService {
    public static void addStation(String stationName) {
        try {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
            StationOutputView.addStationComplete();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteStation(String stationName) {
        try {
            CheckRegisteredStation.validation(stationName);
            StationRepository.deleteStation(stationName);
            StationOutputView.deleteStationComplete();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
