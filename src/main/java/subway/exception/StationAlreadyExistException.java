package subway.exception;

public class StationAlreadyExistException extends RuntimeException{
    private static final String message = "[ERROR] 이미 등록된 지하철 역이 있습니다.";
    public StationAlreadyExistException(){
        super(message);
    }
}
