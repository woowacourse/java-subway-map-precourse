package subway.domain;

import static subway.utils.Constant.MIN_STATION_AND_LINE_NAME_LENGTH;

public class Station {
    private String name;

    public Station(String name) {
        if (name.length() < MIN_STATION_AND_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 역 이름은 2글자 이상이여야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equalsName(String stationName) {
        return this.name.equals(stationName);
    }
}
