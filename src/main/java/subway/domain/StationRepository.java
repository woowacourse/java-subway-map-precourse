package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.constant.BoundaryCheckDigit;

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

    public static boolean findStationFromName(String stationName) {
        return StationRepository
            .stations()
            .stream()
            .map(Station::getName)
            .collect(Collectors.toList())
            .contains(stationName);
    }

    public static Station getStationFromName(String stationName) {
        return StationRepository
            .stations()
            .stream()
            .filter(station -> station.getName().equals(stationName))
            .collect(Collectors.toList())
            .get(BoundaryCheckDigit.LIST_GET_FIRST.getBoundaryCheckDigit());
    }

    public static List<String> registeredStationsInLine() { // 라인에 등록된 역 출력
        List<String> allStations = new ArrayList<>();
        for (Line line : LineRepository.lines()) {
            allStations.addAll(line
                .getLineMembers()
                .stream()
                .map(Station::getName)
                .collect(Collectors.toList()));
        }
        return allStations;
    }
}
