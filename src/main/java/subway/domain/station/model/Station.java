package subway.domain.station.model;

import java.util.Objects;

public class Station {
    private static final int MIN_STATION_NAME_LIMIT = 2;
    private static final String NAME_SHORTER_THAN_MIN_STATION_NAME_LIMIT_MESSAGE = "[ERROR] 지하철 역 이름이 2글자 이상이어야 합니다.\n";

    private final String name;

    public Station(String name) {
        validateStation(name);
        this.name = name;
    }

    private void validateStation(String name) {
        if (name.length() < MIN_STATION_NAME_LIMIT) {
            throw new IllegalArgumentException(NAME_SHORTER_THAN_MIN_STATION_NAME_LIMIT_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isEqualTo(String stationName) {
        return Objects.equals(name, stationName);
    }
}
