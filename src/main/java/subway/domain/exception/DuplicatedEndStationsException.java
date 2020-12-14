package subway.domain.exception;

public class DuplicatedEndStationsException extends IllegalArgumentException {
    public DuplicatedEndStationsException() {
        super("상행 종점과 하행 종점이 같을 수 없습니다.");
    }
}
