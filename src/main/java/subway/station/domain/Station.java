package subway.station.domain;

import subway.station.StationValidator;

public class Station {
    public static final int MIN_NAME_LENGTH = 2;

    private String name;

    public Station(String name) {
        StationValidator.validateRegistration(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
