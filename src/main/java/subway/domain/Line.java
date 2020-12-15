package subway.domain;

import static subway.view.OutputView.INFO_HEAD;

public class Line {
    private final String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public String formatName() {
        return INFO_HEAD + name;
    }

    public boolean isSameNameThan(String comparingName) {
        return this.name.equals(comparingName);
    }
}
