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

    public static void addStation(Station station) {
        validateDuplicate(station);
        stations.add(station);
    }

    private static void validateDuplicate(Station station) {
        Set<Station> duplicateCheckSet = new HashSet<>(stations);
        duplicateCheckSet.add(station);
        if (duplicateCheckSet.size() == stations.size()) {
            throw new IllegalArgumentException(STATION_DUPLICATE_ERROR);
        }
    }

    public static boolean deleteStation(String name) {
        Station targetStation = new Station(name);
        validateNameExist(targetStation);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            if (line.getStations().contains(targetStation)) {
                throw new IllegalArgumentException(STATION_LINE_REGISTER_ERROR);
            }
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void validateNameExist(Station newStation) {
        boolean nameFlag = true;
        for (Station station : stations) {
            if (station.equals(newStation)) {
                nameFlag = false;
                break;
            }
        }
        if (nameFlag) {
            throw new IllegalArgumentException(STATION_EXIST_ERROR);
        }
    }

    public static void registerStationToLine(Station newStation) {
        for (Station station : stations()) {
            if (station.equals(newStation)) {
                station.registerToLine();
                break;
            }
        }
    }

}
