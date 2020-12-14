package subway.validator;

import subway.domain.StationRepository;
import subway.exception.function.RangeIndexOutOfBoundsException;
import subway.exception.validator.NotNumberException;

public final class IndexValidator extends Validator {

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
            throw new NotNumberException();
        }
    }

    private void checkIndex(final String input) {
        boolean lessThanOrEqualToMinimum =
                Integer.parseInt(input) <= StationRepository.MINIMUM_INDEX;

        if (lessThanOrEqualToMinimum) {
            throw new RangeIndexOutOfBoundsException();
        }
    }
}
