package subway.repository;

import subway.domain.Station;
import subway.view.OutputView;

import java.util.*;

import static subway.repository.LineRepository.isStationExistInLine;
import static subway.view.OutputView.*;

public class StationRepository {
    private static final String STATION_DUPLICATE_WARN = "역 이름은 중복이 되어서는 안됩니다.";
    private static final String STATION_NOT_EXIST_WARN = "존재하지 않는 역 이름입니다.";
    private static final String STATION_EXIST_IN_LINE_WARN = "노선에 등록된 역은 삭제할 수 없습니다.";

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static boolean addStation(Station station) {
        if (stations.contains(station)) {
            warnMessage(STATION_DUPLICATE_WARN);
            return false;
        }
        stations.add(station);
        return true;
    }

    public static boolean deleteStation(String name) {
        Station findStation = findStationByName(name);
        if (findStation == null) {
            warnMessage(STATION_NOT_EXIST_WARN);
        }
        if (isStationExistInLine(findStation)) {
            warnMessage(STATION_EXIST_IN_LINE_WARN);
        }
        return stations.remove(findStation);
    }

    public static Station findStationByName(String stationName) {
        Optional<Station> findStation = stations.stream()
                .filter(station -> station.getName().equals(stationName))
                .findAny();
        return findStation.orElse(null);
    }
}
