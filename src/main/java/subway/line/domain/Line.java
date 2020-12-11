package subway.line.domain;

import subway.line.LineValidator;

public class Line {
    public static final int MIN_NAME_LENGTH = 2;

    private String name;
    private Route route;

    public Line(String name) {
        this.name = name;
    }

    public Line(String name, Route route) {
        LineValidator.validateRegistration(name);
        this.name = name;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
