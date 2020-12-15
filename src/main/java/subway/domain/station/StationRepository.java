package subway.domain.station;

import subway.domain.line.LineRepository;

import java.util.*;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static final String STATION_DUPLICATE_ERROR_MESSAGE = "[ERROR] 이미 등록된 역 이름입니다. 중복되지 않는 역이름을 입력해주세요.";
    public static final String STATION_CANNOT_FIND_ERROR_MESSAGE = "[ERROR] 존재하지 않는 역입니다.";
    public static final String LINE_ALREADY_CONTAINS_STATION_ERROR_MESSAGE = "[ERROR] 노선에 등록되어있는 역은 삭제가 불가능합니다.";

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static List<Station> save(Station stationName) {
        if (stations.contains(stationName)) {
            throw new IllegalArgumentException(STATION_DUPLICATE_ERROR_MESSAGE);
        }
        stations.add(stationName);
        return stations;
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static Station findStationName(String stationName) {
        return stations.stream().filter(station -> station.getName().equals(stationName))
                .findAny().orElseThrow(() -> new IllegalArgumentException(STATION_CANNOT_FIND_ERROR_MESSAGE));
    }

    // Line에 station포함되어있으면 station 삭제 못함
    public static boolean deleteStation(String stationName) {
        Station targetStation = findStationName(stationName);
        if (LineRepository.contains(targetStation)) {
            throw new IllegalArgumentException(LINE_ALREADY_CONTAINS_STATION_ERROR_MESSAGE);
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), stationName));
    }

    public static void saveDummyData(List<Station> stations) {
        stations.forEach(StationRepository::save);
    }
}
