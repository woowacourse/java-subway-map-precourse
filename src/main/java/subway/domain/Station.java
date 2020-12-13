package subway.domain;

import static subway.resource.Config.MIN_STATION_NAME_LENGTH;
import static subway.resource.TextResource.ERROR_STATION_NAME_LENGTH;

public class Station {
    private String name;

    public Station(String name) {
        if (name.length() < MIN_STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_STATION_NAME_LENGTH);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
