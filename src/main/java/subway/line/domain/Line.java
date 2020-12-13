package subway.line.domain;

import subway.line.LineValidator;
import subway.station.domain.Station;

import java.util.List;

public class Line {
    public static final int MIN_NAME_LENGTH = 2;

    private final String name;
    private final Route route;

    public Line(String name, Route route) {
        LineValidator.validateRegistration(name);
        this.name = name;
        this.route = route;
    }

    public void insert(int index, Station station) {
        route.insert(index, station);
    }

    public void remove(Station station) {
        station.removeLine(this);
        route.remove(station);
    }

    public void clearUp() {
        route.getStations().forEach(station -> station.removeLine(this));
    }

    public boolean isExist(String stationName) {
        return route.isExist(stationName);
    }

    public boolean isValidOrder(int order) {
        return route.isValidOrder(order);
    }

    public boolean isEnoughSize() {
        return route.isEnoughSize();
    }

    public List<Station> getStations() {
        return route.getStations();
    }

    public String getName() {
        return name;
    }
}
