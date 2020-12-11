package subway.station.exception;

public class TooShortStationNameException extends IllegalArgumentException {
    private static final String MESSAGE = "지하철 역 이름은 두글자 이상으로 입력해주세요. ";

    public TooShortStationNameException() {
        super(MESSAGE);
    }
}
