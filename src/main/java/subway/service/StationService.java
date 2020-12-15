package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;

import java.util.List;

public class StationService {
    public static List<Station> stations() {
        return StationRepository.stations();
    }

    public static void addStation(String stationName) {
        Station station = new Station(stationName);
        StationRepository.addStation(station);
    }

    public static void deleteStationByName(String stationName) {
        StationRepository.deleteStationByName(stationName);
    }
}
