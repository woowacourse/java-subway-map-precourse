package subway.domain;

public class Line {
    private static final int VALID_LENGTH = 2;

    private String name;

    public Line(String name) {
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLength(String userInput) {
        if (!(userInput.length() >= VALID_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }
}
