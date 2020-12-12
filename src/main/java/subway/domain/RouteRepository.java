package subway.domain;

import java.util.*;

public class RouteMapRepository {
    private static final List<RouteMap> routemap = new ArrayList<>();

    public static List<RouteMap> routemaps() {
        return Collections.unmodifiableList(routemap);
    }

    public static void addStation(Station station) {
        routemap.add(station);
    }

    public static boolean deleteStationInLine(String name) {
        return routemap.removeIf(station -> Objects.equals(station.getName(), name));
    }

}
