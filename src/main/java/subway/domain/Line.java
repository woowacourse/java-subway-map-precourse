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
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Line) {
            Line line = (Line) obj;
            return name.equals(line.name);
        }
        return false;
    }
}
