package subway.domain;


import java.util.*;
import java.util.regex.Pattern;

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

    public static boolean isExistName(String name){
        return stations.stream().anyMatch(station -> Objects.equals(station.getName(), name));
    }

    public static boolean isLongName(String name){
        String pattern = "^[a-zA-Z가-힣]{2,}$";
        return Pattern.matches(pattern, name);
    }
}
