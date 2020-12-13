package subway.domain.entity;

public class InvalidSectionOrderException extends RuntimeException {
    private static final String ERROR_MESSAGE = "잘못된 구간 순서 번호를 입력하셨습니다.";

    public InvalidSectionOrderException() {
        super(ERROR_MESSAGE);
    }
}
