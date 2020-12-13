package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    static {
        stations.add(new Station("교대역"));
        stations.add(new Station("강남역"));
        stations.add(new Station("역삼역"));
        stations.add(new Station("남부터미널역"));
        stations.add(new Station("양재역"));
        stations.add(new Station("매봉역"));
        stations.add(new Station("양재시민의숲역"));
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

    public static boolean hasStation(String newStation) {
        for (Station station: stations) {
            if (station.getName().equals(newStation)) {
                return true;
            }
        }
        return false;
    }

//    @Override
    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (Station station: stations) {
            sb.append("[INFO] ");
            sb.append(station.getName());
            sb.append("\n");
        }
//        return sb.toString();
        System.out.println(sb.toString());
    }
}
