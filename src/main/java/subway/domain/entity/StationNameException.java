package subway.domain.entity;

public class StationNameException extends RuntimeException {
    private static final String ERROR_MESSAGE = "이미 등록된 역 이름입니다.";

    public StationNameException() {
        super(ERROR_MESSAGE);
    }
}
