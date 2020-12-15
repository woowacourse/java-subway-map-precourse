package subway.repository;

import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * StationRepository.java : 지하철 역에 대한 저장소 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static List<String> stationNames() {
        List<String> stationNames = new ArrayList<>();

        for (Station station : stations) {
            stationNames.add(station.getName());
        }
        return stationNames;
    }
}
