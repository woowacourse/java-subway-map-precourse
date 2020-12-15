package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class StationService {

    public static void addStation(String stationName) {
        StationRepository.addStation(new Station(stationName));
    }

    public static boolean deleteStation(String stationName) {
        Station station = StationRepository.findStationByName(stationName);
        return station.delete();
    }

    public static List<Station> getStationList() {
        return StationRepository.stations();
    }
}
