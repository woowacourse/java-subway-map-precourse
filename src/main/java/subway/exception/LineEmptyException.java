package subway.exception;

public class LineEmptyException extends RuntimeException{
    private static final String message = "[ERROR] 등록된 지하철 노선이 없습니다.";
    public LineEmptyException(){
        super(message);
    }
}