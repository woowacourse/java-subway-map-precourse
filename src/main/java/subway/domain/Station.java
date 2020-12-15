package subway.domain;

import subway.console.message.ErrorMessage;

public class Station {
    private static final int STATION_NAME_LENGTH = 2;
    private static final String STATION_END_NAME = "역";

    private String name;

    public Station(String name) {
        validateNameLength(name);
        validateNameEndWord(name);
        this.name = name;
    }

    private static void validateNameLength(String name) {
        if (name.length() < STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH.getMessage());
        }
    }

    private static void validateNameEndWord(String name) {
        if (!name.endsWith(STATION_END_NAME)) {
            throw new IllegalArgumentException(ErrorMessage.STATION_NAME_END.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
