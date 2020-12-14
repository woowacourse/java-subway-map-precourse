package subway.domain.validator;

import subway.domain.Order;

public class OrderValidator {
    private static final String BIGGER_THAN_MINIMUM_ERROR = "순서는 %s 이상의 숫자여야 합니다.";

    private OrderValidator() {
    }

    public static void checkIsValidOrder(int order, int minimum) {
        if (order < minimum) {
            String errorMsg = String.format(BIGGER_THAN_MINIMUM_ERROR, minimum);
            throw new IllegalArgumentException(errorMsg);
        }
    }
}
