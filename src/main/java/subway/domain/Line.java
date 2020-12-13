package subway.domain;

public class Line {
    private String name;
    private String upBoundTerminus;
    private String downstreamTerminus;

    public Line(String name, String upBoundTerminus, String downstreamTerminus) {
        this.name = name;
        this.upBoundTerminus = upBoundTerminus;
        this.downstreamTerminus = downstreamTerminus;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
