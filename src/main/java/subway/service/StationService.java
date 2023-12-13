package subway.service;

import java.util.List;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService implements SubwayService {
    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public void addAll(List<String> stations) {
        for (String station : stations) {
            stationRepository.addStation(new Station(station));
        }
    }

    @Override
    public void add(String station) {
        stationRepository.addStation(new Station(station));
    }

    @Override
    public void delete(String station) {
        stationRepository.deleteStation(station);
    }
}
