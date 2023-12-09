package subway.domain;

import static subway.exception.ExceptionMessage.NOT_FOUND_MAIN_OPTION;

import java.util.Arrays;

public enum MainOption {
    STATION("1"),
    LINE("2"),
    SECTION("3"),
    MAP("4"),
    QUIT("Q");

    private final String option;

    MainOption(String option) {
        this.option = option;
    }

    public static MainOption of(String name) {
        return Arrays.stream(values())
                .filter(mainOption -> mainOption.option.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MAIN_OPTION.getMessage()));
    }

    public boolean isQuit() {
        return this.equals(QUIT);
    }
}
