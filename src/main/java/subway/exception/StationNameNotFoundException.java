package subway.exception;

public class StationNameNotFoundException extends IllegalArgumentException {
    private static final String message = "[ERROR] 등록 되어 있지 않은 역입니다.";

    public StationNameNotFoundException() {
        super(message);
    }
}
