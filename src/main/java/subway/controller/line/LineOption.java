package subway.controller.line;

import static subway.exception.ExceptionMessage.NOT_FOUND_OPTION;

import java.util.Arrays;

public enum LineOption {
    ADD("1"),
    DELETE("2"),
    LIST("3"),
    BACK("B"),
    ;
    private final String option;

    LineOption(String option) {
        this.option = option;
    }

    public static LineOption of(String name) {
        return Arrays.stream(values())
                .filter(lineOption -> lineOption.option.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_OPTION.getMessage()));
    }

    public boolean isBack() {
        return this.equals(BACK);
    }
}
