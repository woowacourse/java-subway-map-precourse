package subway.service;

import java.util.List;
import java.util.Optional;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {
    private static final String DUPLICATE_MESSAGE = "[ERROR] 이미 등록된 역 이름입니다.";

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

    public static List<Station> searchStation() {
        return StationRepository.stations();
    }
}
