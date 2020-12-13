package subway.line.exception;

public class SameFinalStationException extends RuntimeException {
    private static final String MESSAGE = "상행 종점과 하행 종점 이름이 같습니다.";

    public SameFinalStationException() {
        super(MESSAGE);
    }
}
