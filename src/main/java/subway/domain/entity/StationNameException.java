package subway.domain.entity;

public class StationNameException extends RuntimeException {
    private static final String ERROR_MESSAGE = "지하철 역 이름은 공백이 아닌 2글자 이상이어야 합니다.";

    public StationNameException() {
        super(ERROR_MESSAGE);
    }
}
