package subway.domain.station;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;

import java.util.*;

public class StationRepository {
    private static final String STATION_DUPLICATE_ERROR = "\n[ERROR] 이미 등록되어 있는 역입니다.";
    private static final String STATION_EXIST_ERROR = "\n[ERROR] 등록되어 있는 역이 아닙니다.";
    private static final String STATION_LINE_REGISTER_ERROR = "\n[ERROR] 노선에 등록되어 있는 역은 삭제할 수 없습니다.";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(StationName stationName) {
        validateDuplicate(stationName);
        stations.add(Station.of(stationName));
    }

    private static void validateDuplicate(StationName stationName) {
        Set<Station> duplicateCheckSet = new HashSet<>(stations);
        duplicateCheckSet.add(Station.of(stationName));
        if (duplicateCheckSet.size() == stations.size()) {
            throw new IllegalArgumentException(STATION_DUPLICATE_ERROR);
        }
    }

    public static boolean deleteStation(StationName stationName) {
        validateNameExist(stationName);
        Station targetStation = Station.of(stationName);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            if (line.getStations().contains(targetStation)) {
                throw new IllegalArgumentException(STATION_LINE_REGISTER_ERROR);
            }
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), stationName));
    }

    public static void validateNameExist(StationName stationName) {
        if (!stations.contains(Station.of(stationName))) {
            throw new IllegalArgumentException(STATION_EXIST_ERROR);
        }
    }
}
