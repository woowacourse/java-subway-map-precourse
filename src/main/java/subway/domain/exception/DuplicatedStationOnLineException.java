package subway.domain.exception;

public class DuplicatedStationOnLineException extends IllegalArgumentException {
    public DuplicatedStationOnLineException() {
        super("이미 노선에 포함된 역입니다.");
    }
}
