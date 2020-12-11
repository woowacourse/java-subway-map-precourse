package subway.station.exception;

public class NotKoreanNameException extends IllegalArgumentException {
    private static final String MESSAGE = "지하철 역은 한국어로 입력해 주세요. ";

    public NotKoreanNameException() {
        super(MESSAGE);
    }
}
