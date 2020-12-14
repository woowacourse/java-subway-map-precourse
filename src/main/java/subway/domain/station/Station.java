package subway.domain.station;

import subway.utils.NameValidator;

public class Station {

    public static final int MINIMUM_NAME_LENGTH = 2;
    public static final String ENDING = "역";

    private final String name;

    public Station(String name) {
        NameValidator.validateStation(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
