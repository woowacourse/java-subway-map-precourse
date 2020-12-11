package subway.line.domain;

public class Line {
    private String name;
    private Route route;

    public Line(String name) {
        this.name = name;
    }

    public Line(String name, Route route) {
        this.name = name;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
