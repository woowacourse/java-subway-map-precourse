package subway.domain;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    @Override
    public String toString() {
        return "[INFO] " + name;
    }
}