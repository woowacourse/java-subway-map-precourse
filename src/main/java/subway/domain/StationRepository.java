package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.service.LineService;

public class StationRepository {

    private static final int EMPTY_STATIONS = 0;

    private static final List<Station> stations = new ArrayList<>();

    public static void addStation(Station station) {
        validateNameDuplicate(station);
        stations.add(station);
    }

    public static void deleteStation(String name) {
        validateStationsEmpty();
        validateRegistered(name);
        if (!stations.removeIf(station -> Objects.equals(station.getName(), name))) {
            throw new IllegalArgumentException("일치하는 지하철 역이 없습니다.");
        }
    }

    public static List<Station> stations() {
        validateStationsEmpty();
        return Collections.unmodifiableList(stations);
    }

    private static void validateNameDuplicate(Station station) {
        if (stations.stream()
            .anyMatch(thisStation -> thisStation.getName().equals(station.getName()))) {
            throw new IllegalArgumentException("동일한 지하철 역 이름이 존재합니다.");
        }
    }

    public static Station findStation(String name) {
        Station foundStation = null;
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                foundStation = station;
                break;
            }
        }
        return foundStation;
    }

    private static void validateRegistered(String name) {
        if (LineService.contain(name)) {
            throw new IllegalArgumentException("지하철 노선에 등록되어 있는 지하철 역은 삭제할 수 없습니다.");
        }
    }

    private static void validateStationsEmpty() {
        if (stations.size() == EMPTY_STATIONS) {
            throw new IllegalArgumentException("등록 되어 있는 지하철 역이 없습니다.");
        }
    }
}