package subway.domain;

public class Station {
    private String name;
    private static final int MIN_NAME_LENGTH = 2;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean isValidNameLength() {
        return name.length() >= MIN_NAME_LENGTH;
    }
}
