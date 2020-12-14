package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final String[] defaultStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

    static {
        for (String s : defaultStations) {
            stations.add(new Station(s));
        }
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static void deleteStationByName(String name) {
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station findStationByName(String name) {
        return stations.stream().filter(station -> station.getName().equals(name))
                .findFirst().get();
    }

    public static boolean isStationPresent(String name) {
        return stations.stream().anyMatch(station -> station.getName().equals(name));
    }
}
