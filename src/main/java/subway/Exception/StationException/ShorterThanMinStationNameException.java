package subway.Exception.StationException;

public class ShorterThanMinStationNameException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 역 이름은 2글자 이상이여야 합니다.";

    public ShorterThanMinStationNameException() {
        super(MESSAGE);
    }
}
