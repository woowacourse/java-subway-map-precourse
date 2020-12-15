package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private Station upTerminal;
    private Station downTerminal;

    public Line(String name, List<Station> terminals) {
        this.name = name;
        this.upTerminal = terminals.get(0);
        this.downTerminal = terminals.get(1);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
