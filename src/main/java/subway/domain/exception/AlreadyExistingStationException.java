package subway.domain.exception;

public class AlreadyExistingStationException extends IllegalArgumentException {
    public AlreadyExistingStationException() {
        super("이미 존재하는 역입니다.");
    }
}