package subway.service;

import java.util.regex.Pattern;

public class SequenceValidator {
    private static final String TYPE_ERROR_MESSAGE = "순서값은 숫자여야 합니다.";
    private static final int MIN_SEQUENCE = 1;
    private static final String MIN_RANGE_ERROR_MESSAGE = "순서값은 " + MIN_SEQUENCE + "이상의 숫자여야 합니다.";
    private static final String MAX_RANGE_ERROR_MESSAGE = "너무 큰 숫자를 입력했습니다.";

    static void validate(String sequence) {
        validateType(sequence);
        validateRange(sequence);
    }

    private static void validateType(String sequence) {
        String regex = "^[0-9]+$";
        if (!Pattern.matches(regex, sequence)) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }

    private static void validateRange(String sequence) {
        validateIntegerRange(sequence);
        int sequenceNumber = Integer.parseInt(sequence);
        if (sequenceNumber < MIN_SEQUENCE) {
            throw new IllegalArgumentException(MIN_RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateIntegerRange(String sequence) {
        try {
            Integer.parseInt(sequence);
        } catch (Exception e) {
            throw new IllegalArgumentException(MAX_RANGE_ERROR_MESSAGE);
        }
    }
}
