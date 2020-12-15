package subway.exception;

public class LineNotExistException extends RuntimeException{
    private static final String message = "[ERROR] 입력하신 지하철 노선이 없습니다.";
    public LineNotExistException(){
        super(message);
    }
}
