package subway.service;

import java.util.List;
import java.util.Optional;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {
    private static final String DUPLICATE_ERROR = "[ERROR] 이미 등록된 역 이름입니다.\n";
    private static final String NOT_DELETE_ERROR = "[ERROR] 삭제할 수 없습니다.\n";
    private static final String NOT_EXIST_ERROR = "[ERROR] 등록할 수 없습니다.\n";

    public static void register(String stationName) {
        validateDuplicate(stationName);
        StationRepository.addStation(new Station(stationName));
    }

    public static List<Station> searchAll() {
        return StationRepository.stations();
    }

    public static Station searchOneByName(String stationName) {
        return StationRepository.findByName(stationName)
            .orElseThrow(()->new IllegalArgumentException(NOT_EXIST_ERROR));
    }

    public static void delete(String stationName) {
        if (!StationRepository.deleteStationByName(stationName)) {
            throw new IllegalArgumentException(NOT_DELETE_ERROR);
        }
    }

    public static boolean hasSameStation(String stationName) {
        Optional<Station> findStation = StationRepository.findByName(stationName);
        return findStation.isPresent();
    }

    private static void validateDuplicate(String stationName) {
        if (hasSameStation(stationName)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }
}
