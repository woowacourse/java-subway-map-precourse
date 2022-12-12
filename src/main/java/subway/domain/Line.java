package subway.domain;

public class Line {
    private static final int MINIMUM_NAME_SIZE = 2;
    private String name;

    public Line(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name.length() < MINIMUM_NAME_SIZE) {
            throw new IllegalArgumentException("[ERROR] 노선 이름은 두 글자 이상으로 입력하세요.");
        }
    }
}
