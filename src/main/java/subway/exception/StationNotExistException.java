package subway.exception;

public class StationNotExistException extends RuntimeException{
    private static final String message = "[ERROR] 입력하신 지하철 역이 없습니다.";
    public StationNotExistException(){
        super(message);
    }
}
