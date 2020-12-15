package subway.exception;

public class CannotRemoveSectionException extends RuntimeException{

    private static final String MESSAGE = "노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다. 다시 입력해주세요.";

    public CannotRemoveSectionException() {
        super(MESSAGE);
    }
}
