package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 지하철 노선 구간의 객체를 관리하는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/13
 */
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

    public static boolean deleteRoute(String lineName, String stationName) {
        Route route = getRouteMatchingName(lineName);
        if (route == null) {
            return false;
        }
        if (route.getNumberOfStations() <= 2) {
            return false;
        }
        getRouteMatchingName(lineName).deleteStation(stationName);
        return true;
    }

    public static void deleteStationOnAllRoute(String stationName){
        for(Route route:routes){
            if(route.doesIncludeStation(stationName))
                route.deleteStation(stationName);
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


    public static boolean deleteLine(String name) {
        return routes.removeIf(route -> route.matchLineName(name));
    }
}
