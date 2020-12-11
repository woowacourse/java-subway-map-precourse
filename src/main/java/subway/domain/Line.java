package subway.domain;

public class Line {
    private Name name;

    public Line(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }

    // 추가 기능 구현
}
