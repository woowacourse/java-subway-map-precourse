package subway.domain;

import subway.exception.BlankNameException;
import subway.exception.TooShortNameException;
import subway.utils.RegexUtil;

public class Station {
    private static final int NAME_LENGTH_MINIMUM = 2;

    private String name;

    public Station(String name) {
        if (name.length() < NAME_LENGTH_MINIMUM) {
            throw new TooShortNameException(name, NAME_LENGTH_MINIMUM);
        }

        if (RegexUtil.isBlank(name)) {
            throw new BlankNameException();
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
