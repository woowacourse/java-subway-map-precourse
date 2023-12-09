package subway.controller.section;

import static subway.exception.ExceptionMessage.NOT_FOUND_OPTION;

import java.util.Arrays;

public enum SectionOption {
    ADD("1"),
    DELETE("2"),
    BACK("B"),
    ;
    private final String option;

    SectionOption(String option) {
        this.option = option;
    }

    public static SectionOption of(String name) {
        return Arrays.stream(values())
                .filter(sectionOption -> sectionOption.option.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_OPTION.getMessage()));
    }

    public boolean isBack() {
        return this.equals(BACK);
    }
}
