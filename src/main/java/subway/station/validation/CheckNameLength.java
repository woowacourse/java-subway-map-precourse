package subway.station.validation;

import subway.common.Prefix;

public class CheckNameLength {
    private static final int MIN_NAME_LENGTH = 2;
    private static final String INVALID_NAME_LENGTH = Prefix.ERROR.getPrefix() + "지하철 역은 2글자 이상이어야 합니다.";

    public static void validation(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }
}
