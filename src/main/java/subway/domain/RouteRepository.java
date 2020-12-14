package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RouteRepository {

    private static final List<Route> routes = new ArrayList<>();

    public static List<Route> routes() {
        return Collections.unmodifiableList(routes);
    }

    public static void addRoute(Route route) {
        routes.add(route);
    }

    public static Route getRouteMatchingName(String lineName) {
        for (Route route : routes) {
            if (route.matchLineName(lineName)) {
                return route;
            }
        }
        return null;
    }

    public static void addStationToLine(String lineName, Station station, int index) {
        Route route = getRouteMatchingName(lineName);
        if (route != null) {
            getRouteMatchingName(lineName).insertStation(station, index);
        }
    }

    public static void deleteRoute(String lineName, String stationName) {
        Route route = getRouteMatchingName(lineName);
        if (route != null) {
            getRouteMatchingName(lineName).deleteStation(stationName);
        }
    }

    public static boolean isLineIncluded(String lineName) {
        Route route = getRouteMatchingName(lineName);
        if (route != null) {
            return true;
        }
        return false;
    }

    public static boolean doesLineIncludeStation(String lineName, String stationName) {
        Route route = getRouteMatchingName(lineName);
        if (route != null) {
            return route.doesIncludeStation(stationName);
        }
        return false;
    }

    public static int numberOfStationsLineHave(String lineName) {
        Route route = getRouteMatchingName(lineName);
        if (route != null) {
            return route.getNumberOfStations();
        }
        return -1;
    }
}
