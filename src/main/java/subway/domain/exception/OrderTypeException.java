package subway.domain.exception;

public class OrderTypeException extends RuntimeException {
    private static final String ORDER_TYPE_ERROR_MESSAGE = "\n[ERROR] 순서는 Integer 형식으로 입력해야 합니다.";

    public OrderTypeException() {
        super(ORDER_TYPE_ERROR_MESSAGE);
    }
}
