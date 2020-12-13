package subway.domain;


import static subway.resource.Config.MIN_LINE_NAME_LENGTH;
import static subway.resource.TextResource.ERROR_LINE_NAME_LENGTH;

public class Line {

    private String name;

    public Line(String name) {
        this.name = name;
        if (name.length() < MIN_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_LINE_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
