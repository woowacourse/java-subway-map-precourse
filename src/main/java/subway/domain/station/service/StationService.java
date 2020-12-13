package subway.domain.station.service;

import subway.domain.line.model.Line;
import subway.domain.line.model.LineRepository;
import subway.domain.station.model.Station;
import subway.domain.station.model.StationRepository;

import java.util.List;

public class StationService {
    private static final String ERROR = "[ERROR] ";
    private static final String NOT_DUPLICATION_STATION_NAME_MESSAGE = "중복된 지하철 역 이름은 등록할 수 없습니다.";
    private static final String IS_CONTAIN_LINE_SECTION_MESSAGE = "이 노선에 포함되어있습니다.";

    public static void save(Station station) {
        validateDuplicationStation(station);
        StationRepository.addStation(station);
    }

    private static void validateDuplicationStation(Station station) {
        List<Station> stations = StationRepository.stations();
        boolean isDuplicated = stations.stream()
                .anyMatch(registeredStation -> registeredStation.isEqualTo(station.getName()));

        if (isDuplicated) {
            throw new IllegalArgumentException(ERROR + NOT_DUPLICATION_STATION_NAME_MESSAGE);
        }
    }

    public static List<Station> findAll() {
        return StationRepository.stations();
    }

    public static void remove(String stationName) {
        validateRemovingStation(stationName);
        StationRepository.deleteStation(stationName);
    }

    private static void validateRemovingStation(String stationName) {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            if (isExist(stationName, line)) {
                throw new IllegalArgumentException(ERROR + stationName + IS_CONTAIN_LINE_SECTION_MESSAGE);
            }
        }
    }

    private static boolean isExist(String stationName, Line line) {
        return line.getStations().stream()
                .anyMatch(station -> station.isEqualTo(stationName));
    }
}
