package subway.station;

import subway.station.validation.CheckRegisteredStation;
import subway.station.view.StationOutputView;

import java.util.List;

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

    public static Station findStation(String stationName) {
        List<Station> stations = StationRepository.stations();
        Station findStation = null;

        for (Station station : stations) {
            String name = station.getName();
            if (name.equals(stationName)) {
                findStation = station;
                break;
            }
        }

        return findStation;
    }
}
