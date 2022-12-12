package subway.domain;

import constants.ExceptionMessage;

public class Station {
    private String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void validate(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_NAME_LENGTH_ERROR.toString());
        }
    }
}
