package subway.section.exception;

public class AlreadyRegisteredStationException extends RuntimeException {
    private static final String MESSAGE = "해당 노선에 이미 등록된 지하철 역 입니다";

    public AlreadyRegisteredStationException() {
        super(MESSAGE);
    }
}
