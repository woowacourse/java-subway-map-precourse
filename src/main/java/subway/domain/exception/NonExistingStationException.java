package subway.domain.exception;

public class NonExistingStationException extends IllegalArgumentException {
    public NonExistingStationException() {
        super("존재하지 않는 역입니다.");
    }
}
