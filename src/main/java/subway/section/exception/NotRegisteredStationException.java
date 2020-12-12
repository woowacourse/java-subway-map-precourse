package subway.section.exception;

public class NotRegisteredStationException extends IllegalArgumentException {
    private static final String MESSAGE = "해당 노선에 등록되지 않은 지하철 역 입니다.";

    public NotRegisteredStationException() {
        super(MESSAGE);
    }
}
