package subway.domain;

import subway.utils.ValidationUtils;

public class Station {
    private static final int NAME_LENGTH_MINIMUM = 2;

    private String name;

    public Station(String name) {
        ValidationUtils.validateTooShortName(name, NAME_LENGTH_MINIMUM);
        ValidationUtils.validateBlankName(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
