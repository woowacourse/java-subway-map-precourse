package subway.domain.validator;

public class OrderValidator {
    private static final String SMALLER_THAN_MINIMUM_ERROR = "순서는 %s 이상의 숫자여야 합니다.";

    private OrderValidator() {
    }

    public static void checkIsValidOrder(int order, int minimum) {
        if (order < minimum) {
            String errorMsg = String.format(SMALLER_THAN_MINIMUM_ERROR, minimum);
            throw new IllegalArgumentException(errorMsg);
        }
    }
}
