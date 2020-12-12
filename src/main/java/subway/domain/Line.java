package subway.domain;

public class Line {
    private String name;
    private LinkRepository linkRepository;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LinkRepository getLinksRepo(){
        return linkRepository;
    }

    // 추가 기능 구현
}
