package subway.controller;

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
}
