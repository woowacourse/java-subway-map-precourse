package subway.section.exception;

public class TooShortToRemoveException extends RuntimeException {
    private static final String MESSAGE = "삭제하려는 구간의 노선에 포함된 역이 두개 이하이면 제거할 수 없습니다.";

    public TooShortToRemoveException() {
        super(MESSAGE);
    }
}
