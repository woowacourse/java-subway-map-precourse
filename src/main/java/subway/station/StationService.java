package subway.station;

import subway.station.domain.Station;
import subway.station.domain.StationRepository;

public class StationService {
    private StationService() {
    }

    public static void register(String name) {
        StationRepository.register(new Station(name));
    }

    public static void remove(String name) {
        StationValidator.validateRemoval(name);
        StationRepository.removeByName(name);
    }
}
