package subway.exception;

public class StationRegisteredInLineException extends RuntimeException {

    private static final String MESSAGE = "노선에 등록된 역은 삭제할 수 없습니다. 다시 입력해주세요.";

    public StationRegisteredInLineException() {
        super(MESSAGE);
    }
}
