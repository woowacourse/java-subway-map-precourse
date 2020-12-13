package subway.validator;

import subway.domain.StationRepository;

public final class IndexValidator extends Validator {

    public static final String LOWER_THAN_MINIMUM_ERROR =
            StationRepository.MINIMUM_INDEX + "초과의 값을 입력해주세요.";

    public static final String NOT_NUMERIC_ERROR = "숫자만 입력해주세요.";

    @Override
    public void validate(final String input) {
        super.validate(input);
        checkNumeric(input);
        checkIndex(input);
    }

    private void checkNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR);
        }
    }

    private void checkIndex(final String input) {
        boolean lessThanOrEqualToMinimum =
                Integer.parseInt(input) <= StationRepository.MINIMUM_INDEX;

        if (lessThanOrEqualToMinimum) {
            throw new IllegalArgumentException(LOWER_THAN_MINIMUM_ERROR);
        }
    }
}
