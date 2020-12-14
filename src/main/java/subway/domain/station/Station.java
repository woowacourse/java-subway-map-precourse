package subway.domain.station;

import subway.utils.StationValidator;

public class Station {

    public static final int MIN_NAME_LENGTH = 2;

    private final String name;

    public Station(String name) {
        StationValidator.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
