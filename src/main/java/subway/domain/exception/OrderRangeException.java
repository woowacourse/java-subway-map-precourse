package subway.domain.exception;

public class OrderRangeException extends RuntimeException {
    private static final String ORDER_RANGE_ERROR_MESSAGE = "\n[ERROR] 순서는 1 ~ (해당 노선의 역 갯수) 사이의 자연수만 입력 가능합니다.";

    public OrderRangeException() {
        super(ORDER_RANGE_ERROR_MESSAGE);
    }
}
