package subway.line.domain;

import subway.line.LineValidator;
import subway.station.domain.Station;

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

    public boolean isExist(String stationName) {
        return route.isExist(stationName);
    }

    public boolean isValidOrder(int order) {
        return route.isValidOrder(order);
    }

    public String getName() {
        return name;
    }
}
