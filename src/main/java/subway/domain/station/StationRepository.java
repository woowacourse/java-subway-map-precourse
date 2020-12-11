package subway.domain.station;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;

import java.util.*;

public class StationRepository {
    private static final String STATION_DUPLICATE_ERROR = "[ERROR] 이미 등록되어 있는 역입니다.";
    private static final String STATION_EXIST_ERROR = "[ERROR] 등록되어 있는 역이 아닙니다.";
    private static final String STATION_LINE_REGISTER_ERROR = "[ERROR] 노선에 등록되어 있는 역은 삭제할 수 없습니다.";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(StationName stationName) {
        validateDuplicate(stationName);
        stations.add(new Station(stationName));
    }

    private static void validateDuplicate(StationName stationName) {
        Set<Station> duplicateCheckSet = new HashSet<>(stations);
        duplicateCheckSet.add(new Station(stationName));
        if (duplicateCheckSet.size() == stations.size()) {
            throw new IllegalArgumentException(STATION_DUPLICATE_ERROR);
        }
    }

    public static boolean deleteStation(StationName stationName) {
        Station targetStation = new Station(stationName);
        validateNameExist(targetStation);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            if (line.getStations().contains(targetStation)) {
                throw new IllegalArgumentException(STATION_LINE_REGISTER_ERROR);
            }
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), stationName));
    }

    public static void validateNameExist(Station station) {
        if (!stations.contains(station)) {
            throw new IllegalArgumentException(STATION_EXIST_ERROR);
        }
    }


}
