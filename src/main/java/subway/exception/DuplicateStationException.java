package subway.exception;

public class DuplicateStationException extends IllegalArgumentException{
    private static final String message = "[ERROR] 상행과 하행 종점은 같은 역이 될 수 없습니다.";
    public DuplicateStationException(){
        super(message);
    }
}
