package subway.service;

public class CannotFindStationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "등록되지 않은 지하철 역 이름을 입력하셨습니다.";

    public CannotFindStationException() {
        super(ERROR_MESSAGE);
    }
}
