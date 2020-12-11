package subway.domain.line;

import subway.view.OutputView;

public class Line {
    public static final int MIN_NAME_LENGTH = 2;

    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void validateName(String name) {
        validateLength(name);
    }

    private static void validateLength(String name) {
        if (shorterThanMinimalLength(name)) {
            throw new IllegalArgumentException(OutputView.ERROR_NAME_SHORT);
        }
    }

    private static boolean shorterThanMinimalLength(String name) {
        return name.length() < MIN_NAME_LENGTH;
    }
}
