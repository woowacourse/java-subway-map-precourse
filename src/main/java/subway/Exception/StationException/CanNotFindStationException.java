package subway.Exception.StationException;

public class CanNotFindStationException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 등록되지 않은 역 입니다.";

    public CanNotFindStationException() {
        super(MESSAGE);
    }
}
