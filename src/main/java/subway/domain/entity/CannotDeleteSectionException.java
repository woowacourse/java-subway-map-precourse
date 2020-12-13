package subway.domain.entity;

public class CannotDeleteSectionException extends RuntimeException {
    private static final String ERROR_MESSAGE = "노선 구간에 포함된 역이 2개 이하인 경우, 구간을 삭제할 수 없습니다.";

    public CannotDeleteSectionException() {
        super(ERROR_MESSAGE);
    }
}
