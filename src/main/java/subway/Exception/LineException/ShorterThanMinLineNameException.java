package subway.Exception.LineException;

public class ShorterThanMinLineNameException extends IllegalArgumentException {
    private static final String message = "[ERROR] 노선 이름은 2글자 이상이여야 합니다.";

    public ShorterThanMinLineNameException() {
        super(message);
    }
}
