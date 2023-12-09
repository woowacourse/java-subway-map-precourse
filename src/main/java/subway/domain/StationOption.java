package subway.domain;

import static subway.exception.ExceptionMessage.NOT_FOUND_OPTION;

import java.util.Arrays;

public enum StationOption {
    ADD("1"),
    DELETE("2"),
    LIST("3"),
    BACK("B"),
    ;
    private final String option;

    StationOption(String option) {
        this.option = option;
    }

    public static StationOption of(String name) {
        return Arrays.stream(values())
                .filter(stationOption -> stationOption.option.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_OPTION.getMessage()));
    }

    public boolean isBack() {
        return this.equals(BACK);
    }
}
