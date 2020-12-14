package subway.repository;

import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static subway.repository.LineRepository.isStationExistInLine;
import static subway.repository.LineRepository.lines;
import static subway.view.OutputView.*;

public class StationRepository {
    private static final String STATION_DUPLICATE_WARN = "역 이름은 중복이 되어서는 안됩니다.";
    private static final String STATION_NOT_EXIST_WARN = "존재하지 않는 역입니다.";
    private static final String STATION_EXIST_IN_LINE_WARN = "노선에 등록된 역은 삭제할 수 없습니다.";
    private static final String STATION_ADD_SUCCESS = "지하철 역이 등록되었습니다.";
    private static final String STATION_DELETE_SUCCESS = "지하철 역이 삭제되었습니다.";
    private static final String STATION_SIZE_ZERO = "등록된 역이 없습니다.";

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            warnMessage(STATION_DUPLICATE_WARN);
            return;
        }
        stations.add(station);
        infoMessage(STATION_ADD_SUCCESS);
    }

    public static void deleteStationByName(String name) {
        Station findStation = findStationByName(name);
        if (findStation == null) {
            return;
        }
        if (isStationExistInLine(findStation)) {
            warnMessage(STATION_EXIST_IN_LINE_WARN);
            return;
        }
        infoMessage(STATION_DELETE_SUCCESS);
        stations.remove(findStation);
    }

    public static Station findStationByName(String stationName) {
        Optional<Station> findStation = stations.stream()
                .filter(station -> station.getName().equals(stationName))
                .findAny();

        if (findStation.isEmpty()) {
            warnMessage(STATION_NOT_EXIST_WARN);
            return null;
        }

        return findStation.get();
    }

    public static void printStationList() {
        if (stations.size() == 0) {
            infoMessage(STATION_SIZE_ZERO);
            return;
        }
        stations.forEach(station -> infoMessageNotBr(station.getName()));
        System.out.println();
    }
}
