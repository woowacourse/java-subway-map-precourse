package subway.domain.station;

import subway.exception.NameLengthException;

public class Station {
    private static final int NAME_LENGTH_MIN = 2;
    
    private String name;

    public Station(String name) {
        if (name.length() < NAME_LENGTH_MIN) {
            throw new NameLengthException();
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
