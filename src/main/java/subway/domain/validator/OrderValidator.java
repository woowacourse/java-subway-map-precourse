package subway.domain.validator;

import subway.domain.exception.InvalidOrderException;

public class OrderValidator {
    private OrderValidator() {
    }

    public static void checkIsValidOrder(int order, int minimum) {
        if (order < minimum) {
            throw new InvalidOrderException();
        }
    }
}
