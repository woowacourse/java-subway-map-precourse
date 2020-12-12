package subway.controller;

import java.util.List;
import subway.domain.Station;
import subway.repository.StationRepository;

/**
 * @author yhh1056
 * @since 2020/12/12
 */
public class StationController {

    public void createStation(final String name) {
        StationRepository.addStation(new Station(name));
    }

    public boolean deleteStation(String name) {
        return StationRepository.deleteStation(name);
    }

    public List<Station> findAll() {
        return StationRepository.stations();
    }
}
