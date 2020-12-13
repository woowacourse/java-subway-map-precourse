package subway.domain.entity;

public class LineNameException extends RuntimeException {
    private static final String ERROR_MESSAGE = "지하철 노선 이름은 공백이 아닌 2글자 이상이어야 합니다.";

    public LineNameException() {
        super(ERROR_MESSAGE);
    }
}
