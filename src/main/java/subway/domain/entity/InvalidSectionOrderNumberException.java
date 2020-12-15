package subway.domain.entity;

public class InvalidSectionOrderNumberException extends RuntimeException {
    private static final String ERROR_MESSAGE = "잘못된 구간 순서 번호를 입력하셨습니다.";

    public InvalidSectionOrderNumberException() {
        super(ERROR_MESSAGE);
    }
}
