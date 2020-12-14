package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    public static void save(Station station) {
        StationRepository.addStation(station);
    }
}
