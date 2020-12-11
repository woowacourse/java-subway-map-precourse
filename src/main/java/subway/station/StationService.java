package subway.station;

import subway.station.domain.Station;
import subway.station.domain.StationRepository;

public class StationService {
    private StationService() {
    }

    public static void register(String name) {
        StationRepository.addStation(new Station(name));
    }

    public static void remove(String name) {
        StationRepository.deleteStation(name);
    }
}
