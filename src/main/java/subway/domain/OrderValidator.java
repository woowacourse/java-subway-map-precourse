package subway.domain;

public class OrderValidator {
    private static final String ERROR_MESSAGE_WITH_NUMBER = "순서 입력은 숫자입니다.";
    private static final String ERROR_MESSAGE_WITH_NEGATIVE = "순서는 0 이상이어야 합니다.";
    private static final int MINIMUM_OF_ORDER = 0;
    public static final int NOT_NUMBER_FLAG = -1;

    public static int makeValidOrder(final String inputOrder) {
        checkNumber(inputOrder);
        return checkMoreThanZero(isNotNumber(inputOrder));
    }

    private static void checkNumber(final String inputOrder) {
        if (isNotNumber(inputOrder)==-1) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WITH_NUMBER);
        }
    }

    private static int isNotNumber(final String inputOrder) {
        try {
            return Integer.parseInt(inputOrder);
        } catch (NumberFormatException e) {
            return NOT_NUMBER_FLAG;
        }
    }

    private static int checkMoreThanZero(final int order) {
        if (order < MINIMUM_OF_ORDER) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WITH_NEGATIVE);
        }
        return order;
    }

}
