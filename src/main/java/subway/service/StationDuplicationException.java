package subway.service;

public class StationDuplicationException extends RuntimeException {
    private static final String ERROR_MESSAGE = "이미 등록된 역 이름입니다.";

    public StationDuplicationException() {
        super(ERROR_MESSAGE);
    }
}
