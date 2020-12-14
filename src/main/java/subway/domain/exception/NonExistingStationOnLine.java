package subway.domain.exception;

public class NonExistingStationOnLine extends IllegalArgumentException {
    public NonExistingStationOnLine() {
        super("노선 위에 존재하지 역이 아닙니다.");
    }
}
