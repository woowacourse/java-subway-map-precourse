package subway.service;

public class CannotFindLineException extends RuntimeException {
    private static final String ERROR_MESSAGE = "등록되지 않은 지하철 노선 이름을 입력하셨습니다.";

    public CannotFindLineException() {
        super(ERROR_MESSAGE);
    }
}
