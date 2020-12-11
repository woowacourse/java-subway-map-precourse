package subway.domain;

public class Station {
    public static int MINIMUM_NAME_LENGTH = 2;
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
