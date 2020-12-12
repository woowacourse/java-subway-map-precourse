package subway.domain;

public class Line {
    private String name;
    private PathRepository pathRepository;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public PathRepository getLinksRepo(){
        return pathRepository;
    }

    // 추가 기능 구현
}
