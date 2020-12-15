package subway.exception;

public class AlreadyExistException extends RuntimeException{
    private static final String message = "[ERROR] 이미 등록되어있는 역입니다.";
    public AlreadyExistException(){
        super(message);
    }
}
