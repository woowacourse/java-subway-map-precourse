package subway.exception;

public class InvalidIndexException extends RuntimeException {

    private static final String MESSAGE = "입력한 순서가 구간의 범위를 벗어났습니다. 다시 입력해주세요. 입력값: (%s)";

    public InvalidIndexException(String index) {
        super(String.format(MESSAGE, index));
    }
}
