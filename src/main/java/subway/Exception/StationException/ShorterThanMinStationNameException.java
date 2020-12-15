package subway.Exception.StationException;

public class ShorterThanMinStationNameException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 이미 등록된 역 이름입니다.";

    public ShorterThanMinStationNameException() {
        super(MESSAGE);
    }
}
