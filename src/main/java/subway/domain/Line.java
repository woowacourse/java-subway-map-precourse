package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public static int NAME_LENGTH_MIN = 2;
    public static int ROUTE_LENGTH_MIN = 2;
    public static int ROUTE_START = 1;
    
    private String name;
    private final List<Station> route = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean nameEquals(String name) {
        return this.name.equals(name);
    }

    void addStationToRoute(Station station) {
        route.add(station);
    }

    void addStationToRoute(int index, Station station) {
        route.add(index, station);
    }

    void removeStationFromRoute(Station station) {
        route.remove(station);
    }
    
    boolean containsStationInRoute(Station station) {
        return route.contains(station);
    }

    int routeLength() {
        return route.size();
    }
}
