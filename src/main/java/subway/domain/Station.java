package subway.domain;

public class Station {
    private static final int MIN_LENGTH_OF_STATION_NAME = 2;
    private String name;

    public Station(String name) {
        validateStationName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateStationName(String name) {
        if (name.length() < MIN_LENGTH_OF_STATION_NAME) {
            throw new IllegalArgumentException("역의 이름은 2글자 이상이어야 합니다.");
        }
    }

    // 추가 기능 구현
}
