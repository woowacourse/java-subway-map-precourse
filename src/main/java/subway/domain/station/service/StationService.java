package subway.domain.station.service;

import subway.domain.station.model.Station;
import subway.domain.station.model.StationRepository;

import java.util.List;

public class StationService {
    private static final String NOT_DUPLICATION_STATION_NAME_MESSAGE = "[ERROR] 중복된 지하철 역 이름은 등록할 수 없습니다.";

    public static void registerStation(Station station) {
        validateDuplicationStation(station);
        StationRepository.addStation(station);
    }

    private static void validateDuplicationStation(Station station) {
        List<Station> stations = StationRepository.stations();
        boolean isDuplicated = stations.stream()
                .anyMatch(registeredStation -> registeredStation.isEqualTo(station));

        if (isDuplicated) {
            throw new IllegalArgumentException(NOT_DUPLICATION_STATION_NAME_MESSAGE);
        }
    }

    public static List<Station> findAll() {
        return StationRepository.stations();
    }

    public static void remove(Station station) {
        StationRepository.deleteStation(station.getName());
    }
}
