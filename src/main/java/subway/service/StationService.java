package subway.service;

import java.util.Optional;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {
    private static final String DUPLICATE_MESSAGE = "이름이 중복됩니다.";

    public static void registerStation(String stationName) {
        if (hasSameName(stationName)) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
        StationRepository.addStation(new Station(stationName));
    }

    private static boolean hasSameName(String stationName) {
        Optional<Station> findStation = StationRepository.findByName(stationName);
        return findStation.isPresent();
    }
}
