package subway.Exception.StationException;

public class CanNotDeleteStationException extends IllegalArgumentException{
    public static final String MESSAGE = "[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.";

    public CanNotDeleteStationException() {
        super(MESSAGE);
    }
}
