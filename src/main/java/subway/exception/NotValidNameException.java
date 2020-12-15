package subway.exception;

public class NotValidNameException extends IllegalArgumentException{
    private static final String message = "[ERROR] 지하철 역 이름은 2글자 이상이어야 합니다.";
    public NotValidNameException(){
        super(message);
    }
}
