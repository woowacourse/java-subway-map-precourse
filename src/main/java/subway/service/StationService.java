package subway.service;

import subway.domain.entity.Station;
import subway.domain.repository.StationRepository;

public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void addStationByName(String name) {
        stationRepository.findByName(name)
                .ifPresent(station -> {
                    throw new StationDuplicationException();
                });
        Station station = new Station(name);
        stationRepository.save(station);
    }

    public boolean deleteStationByName(String name) {
        Station station = stationRepository.findByName(name)
                .orElseThrow(CannotFindStationException::new);
        if (station.isRegisteredAsSection()) {
            throw new CannotDeleteStationException();
        }
        return stationRepository.delete(station);
    }
}
