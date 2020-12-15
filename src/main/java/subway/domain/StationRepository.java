package subway.domain;

import java.util.*;

public class StationRepository {
    private static final List<Station> stations = Arrays.asList(new Station("교대역"), new Station("강남역"), new Station("역삼역"), new Station("남부터미널역"), new Station("양재역"), new Station("양재시민의숲역"), new Station("매봉역"));

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station getStationByName(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }

        return null;
    }
}
