package subway.domain;

public class Station {
    private static final int MIN_LENGTH = 2;
    private static final String INVALID_LENGTH_FORMAT = "이름은 %d 글자 이상이어야 합니다.";

    private String name;

    public Station(String name) {
        if (name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_LENGTH_FORMAT, MIN_LENGTH));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
