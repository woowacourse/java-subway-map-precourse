package subway.domain.entity;

public class SectionDuplicationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "해당 노선의 구간으로 등록된 역을 중복 입력하셨습니다.";

    public SectionDuplicationException() {
        super(ERROR_MESSAGE);
    }
}
