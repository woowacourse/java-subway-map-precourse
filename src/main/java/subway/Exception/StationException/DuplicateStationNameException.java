package subway.Exception.StationException;

public class DuplicateStationNameException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 이미 등록된 역 이름입니다.";

    public DuplicateStationNameException() {
        super(MESSAGE);
    }
}
