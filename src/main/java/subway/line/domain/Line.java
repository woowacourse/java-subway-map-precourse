package subway.line.domain;

import subway.line.LineValidator;
import subway.station.domain.Station;

import java.util.List;

public class Line {
    public static final int MIN_NAME_LENGTH = 2;

    private String name;
    private Route route;

    public Line(String name) {
        this.name = name;
    }

    public Line(String name, Route route) {
        LineValidator.validateRegistration(name);
        this.name = name;
        this.route = route;
    }

    public void insert(int index, Station station) {
        this.route.insert(index, station);
    }

    public void remove(Station station) {
        this.route.remove(station);
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
        return this.route.isEnoughSize();
    }

    public List<Station> getStations() {
        return this.route.getStations();
    }

    public String getName() {
        return name;
    }
}
