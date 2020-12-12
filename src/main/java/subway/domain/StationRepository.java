package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private static final int EMPTY_STATIONS = 0;

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        validateStationsEmpty();
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validateNameDuplicate(station);
        stations.add(station);
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

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static void validateStationsEmpty() {
        if (stations.size() == EMPTY_STATIONS) {
            throw new IllegalArgumentException("등록 되어 있는 지하철 역이 없습니다.");
        }
    }

    private static void validateNameDuplicate(Station station) {
        if (stations.stream()
            .anyMatch(thisStation -> thisStation.getName().equals(station.getName()))) {
            throw new IllegalArgumentException("동일한 지하철 역 이름이 존재합니다.");
        }
    }
}