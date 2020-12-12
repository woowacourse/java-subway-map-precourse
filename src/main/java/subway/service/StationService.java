package subway.service;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.List;

public class StationService {
    public void addStation(Station station) {
        StationRepository.addStation(station);
    }

    public boolean deleteStation(String stationName) {
        return StationRepository.deleteStation(stationName);
    }

    public List<Station> getStations() {
        return StationRepository.stations();
    }
}
