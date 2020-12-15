package subway.exception;

public class LineAlreadyExistException extends RuntimeException{
    private static final String message = "[ERROR] 이미 등록된 지하철 노선이 있습니다.";
    public LineAlreadyExistException(){
        super(message);
    }
}
