package subway.domain;

public class OrderValidator {
    private static final int MINIMUM_OF_ORDER = 0;
    private static final int NOT_NUMBER_FLAG = -1;
    private static final int ORDER_FORMATTER = 1;
    private static final int POSSIBLE_ORDER_FORMATTER = 1;

    public static int makeValidOrder(final String inputOrder, final Integer lineSize) {
        int inputNumber = makeNumber(inputOrder);
        checkNumber(inputOrder);
        checkLessThanSize(inputNumber, lineSize);
        checkMoreThanZero(inputNumber);
        return inputNumber - ORDER_FORMATTER;
    }

    private static int makeNumber(final String inputOrder) {
        try {
            return Integer.parseInt(inputOrder);
        } catch (NumberFormatException e) {
            return NOT_NUMBER_FLAG;
        }
    }

    private static void checkNumber(final String inputOrder) {
        if (makeNumber(inputOrder) == NOT_NUMBER_FLAG) {
            throw new IllegalArgumentException("순서 입력은 숫자입니다.");
        }
    }

    private static void checkLessThanSize(int number, Integer lineSize) {
        if (number > lineSize + POSSIBLE_ORDER_FORMATTER) {
            throw new IllegalArgumentException("순서가 해당 호선의 역 수보다 큽니다.");
        }
    }

    private static void checkMoreThanZero(final int order) {
        if (order <= MINIMUM_OF_ORDER) {
            throw new IllegalArgumentException("순서는 1부터 시작합니다.");
        }
    }
}
