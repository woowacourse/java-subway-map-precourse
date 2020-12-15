package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static void init() {
        stations.add(new Station(new StationName("교대역")));
        stations.add(new Station(new StationName("강남역")));
        stations.add(new Station(new StationName("역삼역")));
        stations.add(new Station(new StationName("남부터미널역")));
        stations.add(new Station(new StationName("양재역")));
        stations.add(new Station(new StationName("양재시민의숲역")));
        stations.add(new Station(new StationName("매봉역")));
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
