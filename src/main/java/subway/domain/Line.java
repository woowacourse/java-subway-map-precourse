package subway.domain;

public class Line {
    private String name;
    private String upTerminal;
    private String downTerninal;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void setTerminal(String upTerminal, String downTerninal) {
        this.upTerminal = upTerminal;
        this.downTerninal = downTerninal;
    }
}
