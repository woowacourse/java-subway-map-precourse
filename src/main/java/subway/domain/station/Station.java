package subway.domain.station;

import subway.domain.station.exception.ShorterThanMinStationNameException;

public class Station {

    public static final int MIN_NAME_SIZE = 2;

    private String name;

    public Station(String name) {
        this.name = name;
    }

    public static Station from(String name) {
        if (name.length() < MIN_NAME_SIZE) {
            throw new ShorterThanMinStationNameException(name);
        }

        return new Station(name);
    }

    public String getName() {
        return name;
    }
}
