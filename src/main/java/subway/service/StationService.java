package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.View;

public class StationService {

    public static void save(String stationName) {
        Station newStation = Station.newStation(stationName);
        StationRepository.addStation(newStation);
    }

    public static void delete(String stationName) {
        StationRepository.deleteStation(stationName);
    }

    public static void printAll() {
        View.printAllStations(StationRepository.stations());
    }
}
